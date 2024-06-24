/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edusys_project.controller.JPA;

import edusys_project.controller.JPA.exceptions.NonexistentEntityException;
import edusys_project.controller.JPA.exceptions.PreexistingEntityException;
import edusys_project.model.Activities;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
public class ActivitiesJpaController implements Serializable {

    public ActivitiesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Activities activities) throws PreexistingEntityException, Exception {
        if (activities.getUsersCollection() == null) {
            activities.setUsersCollection(new ArrayList<Users>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Users> attachedUsersCollection = new ArrayList<Users>();
            for (Users usersCollectionUsersToAttach : activities.getUsersCollection()) {
                usersCollectionUsersToAttach = em.getReference(usersCollectionUsersToAttach.getClass(), usersCollectionUsersToAttach.getIdUsers());
                attachedUsersCollection.add(usersCollectionUsersToAttach);
            }
            activities.setUsersCollection(attachedUsersCollection);
            em.persist(activities);
            for (Users usersCollectionUsers : activities.getUsersCollection()) {
                usersCollectionUsers.getActivitiesCollection().add(activities);
                usersCollectionUsers = em.merge(usersCollectionUsers);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findActivities(activities.getIdActivities()) != null) {
                throw new PreexistingEntityException("Activities " + activities + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Activities activities) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Activities persistentActivities = em.find(Activities.class, activities.getIdActivities());
            Collection<Users> usersCollectionOld = persistentActivities.getUsersCollection();
            Collection<Users> usersCollectionNew = activities.getUsersCollection();
            Collection<Users> attachedUsersCollectionNew = new ArrayList<Users>();
            for (Users usersCollectionNewUsersToAttach : usersCollectionNew) {
                usersCollectionNewUsersToAttach = em.getReference(usersCollectionNewUsersToAttach.getClass(), usersCollectionNewUsersToAttach.getIdUsers());
                attachedUsersCollectionNew.add(usersCollectionNewUsersToAttach);
            }
            usersCollectionNew = attachedUsersCollectionNew;
            activities.setUsersCollection(usersCollectionNew);
            activities = em.merge(activities);
            for (Users usersCollectionOldUsers : usersCollectionOld) {
                if (!usersCollectionNew.contains(usersCollectionOldUsers)) {
                    usersCollectionOldUsers.getActivitiesCollection().remove(activities);
                    usersCollectionOldUsers = em.merge(usersCollectionOldUsers);
                }
            }
            for (Users usersCollectionNewUsers : usersCollectionNew) {
                if (!usersCollectionOld.contains(usersCollectionNewUsers)) {
                    usersCollectionNewUsers.getActivitiesCollection().add(activities);
                    usersCollectionNewUsers = em.merge(usersCollectionNewUsers);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = activities.getIdActivities();
                if (findActivities(id) == null) {
                    throw new NonexistentEntityException("The activities with id " + id + " no longer exists.");
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
            Activities activities;
            try {
                activities = em.getReference(Activities.class, id);
                activities.getIdActivities();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The activities with id " + id + " no longer exists.", enfe);
            }
            Collection<Users> usersCollection = activities.getUsersCollection();
            for (Users usersCollectionUsers : usersCollection) {
                usersCollectionUsers.getActivitiesCollection().remove(activities);
                usersCollectionUsers = em.merge(usersCollectionUsers);
            }
            em.remove(activities);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Activities> findActivitiesEntities() {
        return findActivitiesEntities(true, -1, -1);
    }

    public List<Activities> findActivitiesEntities(int maxResults, int firstResult) {
        return findActivitiesEntities(false, maxResults, firstResult);
    }

    private List<Activities> findActivitiesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Activities.class));
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

    public Activities findActivities(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Activities.class, id);
        } finally {
            em.close();
        }
    }

    public int getActivitiesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Activities> rt = cq.from(Activities.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
