/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edusys_project.controller.JPA;

import edusys_project.controller.JPA.exceptions.NonexistentEntityException;
import edusys_project.controller.JPA.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import edusys_project.model.Course;
import edusys_project.model.Groups;
import edusys_project.model.Users;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author fcama
 */
public class GroupsJpaController implements Serializable {

    public GroupsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Groups groups) throws PreexistingEntityException, Exception {
        if (groups.getUsersCollection() == null) {
            groups.setUsersCollection(new ArrayList<Users>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Course coursesyllabus = groups.getCoursesyllabus();
            if (coursesyllabus != null) {
                coursesyllabus = em.getReference(coursesyllabus.getClass(), coursesyllabus.getSyllabus());
                groups.setCoursesyllabus(coursesyllabus);
            }
            Collection<Users> attachedUsersCollection = new ArrayList<Users>();
            for (Users usersCollectionUsersToAttach : groups.getUsersCollection()) {
                usersCollectionUsersToAttach = em.getReference(usersCollectionUsersToAttach.getClass(), usersCollectionUsersToAttach.getIdUsers());
                attachedUsersCollection.add(usersCollectionUsersToAttach);
            }
            groups.setUsersCollection(attachedUsersCollection);
            em.persist(groups);
            if (coursesyllabus != null) {
                coursesyllabus.getGroupsCollection().add(groups);
                coursesyllabus = em.merge(coursesyllabus);
            }
            for (Users usersCollectionUsers : groups.getUsersCollection()) {
                usersCollectionUsers.getGroupsCollection().add(groups);
                usersCollectionUsers = em.merge(usersCollectionUsers);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findGroups(groups.getIdGroup()) != null) {
                throw new PreexistingEntityException("Groups " + groups + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Groups groups) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Groups persistentGroups = em.find(Groups.class, groups.getIdGroup());
            Course coursesyllabusOld = persistentGroups.getCoursesyllabus();
            Course coursesyllabusNew = groups.getCoursesyllabus();
            Collection<Users> usersCollectionOld = persistentGroups.getUsersCollection();
            Collection<Users> usersCollectionNew = groups.getUsersCollection();
            if (coursesyllabusNew != null) {
                coursesyllabusNew = em.getReference(coursesyllabusNew.getClass(), coursesyllabusNew.getSyllabus());
                groups.setCoursesyllabus(coursesyllabusNew);
            }
            Collection<Users> attachedUsersCollectionNew = new ArrayList<Users>();
            for (Users usersCollectionNewUsersToAttach : usersCollectionNew) {
                usersCollectionNewUsersToAttach = em.getReference(usersCollectionNewUsersToAttach.getClass(), usersCollectionNewUsersToAttach.getIdUsers());
                attachedUsersCollectionNew.add(usersCollectionNewUsersToAttach);
            }
            usersCollectionNew = attachedUsersCollectionNew;
            groups.setUsersCollection(usersCollectionNew);
            groups = em.merge(groups);
            if (coursesyllabusOld != null && !coursesyllabusOld.equals(coursesyllabusNew)) {
                coursesyllabusOld.getGroupsCollection().remove(groups);
                coursesyllabusOld = em.merge(coursesyllabusOld);
            }
            if (coursesyllabusNew != null && !coursesyllabusNew.equals(coursesyllabusOld)) {
                coursesyllabusNew.getGroupsCollection().add(groups);
                coursesyllabusNew = em.merge(coursesyllabusNew);
            }
            for (Users usersCollectionOldUsers : usersCollectionOld) {
                if (!usersCollectionNew.contains(usersCollectionOldUsers)) {
                    usersCollectionOldUsers.getGroupsCollection().remove(groups);
                    usersCollectionOldUsers = em.merge(usersCollectionOldUsers);
                }
            }
            for (Users usersCollectionNewUsers : usersCollectionNew) {
                if (!usersCollectionOld.contains(usersCollectionNewUsers)) {
                    usersCollectionNewUsers.getGroupsCollection().add(groups);
                    usersCollectionNewUsers = em.merge(usersCollectionNewUsers);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = groups.getIdGroup();
                if (findGroups(id) == null) {
                    throw new NonexistentEntityException("The groups with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Groups groups;
            try {
                groups = em.getReference(Groups.class, id);
                groups.getIdGroup();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The groups with id " + id + " no longer exists.", enfe);
            }
            Course coursesyllabus = groups.getCoursesyllabus();
            if (coursesyllabus != null) {
                coursesyllabus.getGroupsCollection().remove(groups);
                coursesyllabus = em.merge(coursesyllabus);
            }
            Collection<Users> usersCollection = groups.getUsersCollection();
            for (Users usersCollectionUsers : usersCollection) {
                usersCollectionUsers.getGroupsCollection().remove(groups);
                usersCollectionUsers = em.merge(usersCollectionUsers);
            }
            em.remove(groups);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Groups> findGroupsEntities() {
        return findGroupsEntities(true, -1, -1);
    }

    public List<Groups> findGroupsEntities(int maxResults, int firstResult) {
        return findGroupsEntities(false, maxResults, firstResult);
    }

    private List<Groups> findGroupsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Groups.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Groups findGroups(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Groups.class, id);
        } finally {
            em.close();
        }
    }

    public int getGroupsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Groups> rt = cq.from(Groups.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
