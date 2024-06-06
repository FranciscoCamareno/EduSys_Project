/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edusys_project.controller.JPA;

import edusys_project.controller.JPA.exceptions.IllegalOrphanException;
import edusys_project.controller.JPA.exceptions.NonexistentEntityException;
import edusys_project.controller.JPA.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import edusys_project.model.Module;
import edusys_project.model.Profile;
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
public class ProfileJpaController implements Serializable {

    public ProfileJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Profile profile) throws PreexistingEntityException, Exception {
        if (profile.getUsersCollection() == null) {
            profile.setUsersCollection(new ArrayList<Users>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Module moduleidModule = profile.getModuleidModule();
            if (moduleidModule != null) {
                moduleidModule = em.getReference(moduleidModule.getClass(), moduleidModule.getIdModule());
                profile.setModuleidModule(moduleidModule);
            }
            Collection<Users> attachedUsersCollection = new ArrayList<Users>();
            for (Users usersCollectionUsersToAttach : profile.getUsersCollection()) {
                usersCollectionUsersToAttach = em.getReference(usersCollectionUsersToAttach.getClass(), usersCollectionUsersToAttach.getIdUsers());
                attachedUsersCollection.add(usersCollectionUsersToAttach);
            }
            profile.setUsersCollection(attachedUsersCollection);
            em.persist(profile);
            if (moduleidModule != null) {
                moduleidModule.getProfileCollection().add(profile);
                moduleidModule = em.merge(moduleidModule);
            }
            for (Users usersCollectionUsers : profile.getUsersCollection()) {
                Profile oldProfileidProfileOfUsersCollectionUsers = usersCollectionUsers.getProfileidProfile();
                usersCollectionUsers.setProfileidProfile(profile);
                usersCollectionUsers = em.merge(usersCollectionUsers);
                if (oldProfileidProfileOfUsersCollectionUsers != null) {
                    oldProfileidProfileOfUsersCollectionUsers.getUsersCollection().remove(usersCollectionUsers);
                    oldProfileidProfileOfUsersCollectionUsers = em.merge(oldProfileidProfileOfUsersCollectionUsers);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProfile(profile.getIdProfile()) != null) {
                throw new PreexistingEntityException("Profile " + profile + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Profile profile) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Profile persistentProfile = em.find(Profile.class, profile.getIdProfile());
            Module moduleidModuleOld = persistentProfile.getModuleidModule();
            Module moduleidModuleNew = profile.getModuleidModule();
            Collection<Users> usersCollectionOld = persistentProfile.getUsersCollection();
            Collection<Users> usersCollectionNew = profile.getUsersCollection();
            List<String> illegalOrphanMessages = null;
            for (Users usersCollectionOldUsers : usersCollectionOld) {
                if (!usersCollectionNew.contains(usersCollectionOldUsers)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Users " + usersCollectionOldUsers + " since its profileidProfile field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (moduleidModuleNew != null) {
                moduleidModuleNew = em.getReference(moduleidModuleNew.getClass(), moduleidModuleNew.getIdModule());
                profile.setModuleidModule(moduleidModuleNew);
            }
            Collection<Users> attachedUsersCollectionNew = new ArrayList<Users>();
            for (Users usersCollectionNewUsersToAttach : usersCollectionNew) {
                usersCollectionNewUsersToAttach = em.getReference(usersCollectionNewUsersToAttach.getClass(), usersCollectionNewUsersToAttach.getIdUsers());
                attachedUsersCollectionNew.add(usersCollectionNewUsersToAttach);
            }
            usersCollectionNew = attachedUsersCollectionNew;
            profile.setUsersCollection(usersCollectionNew);
            profile = em.merge(profile);
            if (moduleidModuleOld != null && !moduleidModuleOld.equals(moduleidModuleNew)) {
                moduleidModuleOld.getProfileCollection().remove(profile);
                moduleidModuleOld = em.merge(moduleidModuleOld);
            }
            if (moduleidModuleNew != null && !moduleidModuleNew.equals(moduleidModuleOld)) {
                moduleidModuleNew.getProfileCollection().add(profile);
                moduleidModuleNew = em.merge(moduleidModuleNew);
            }
            for (Users usersCollectionNewUsers : usersCollectionNew) {
                if (!usersCollectionOld.contains(usersCollectionNewUsers)) {
                    Profile oldProfileidProfileOfUsersCollectionNewUsers = usersCollectionNewUsers.getProfileidProfile();
                    usersCollectionNewUsers.setProfileidProfile(profile);
                    usersCollectionNewUsers = em.merge(usersCollectionNewUsers);
                    if (oldProfileidProfileOfUsersCollectionNewUsers != null && !oldProfileidProfileOfUsersCollectionNewUsers.equals(profile)) {
                        oldProfileidProfileOfUsersCollectionNewUsers.getUsersCollection().remove(usersCollectionNewUsers);
                        oldProfileidProfileOfUsersCollectionNewUsers = em.merge(oldProfileidProfileOfUsersCollectionNewUsers);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = profile.getIdProfile();
                if (findProfile(id) == null) {
                    throw new NonexistentEntityException("The profile with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Profile profile;
            try {
                profile = em.getReference(Profile.class, id);
                profile.getIdProfile();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The profile with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Users> usersCollectionOrphanCheck = profile.getUsersCollection();
            for (Users usersCollectionOrphanCheckUsers : usersCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Profile (" + profile + ") cannot be destroyed since the Users " + usersCollectionOrphanCheckUsers + " in its usersCollection field has a non-nullable profileidProfile field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Module moduleidModule = profile.getModuleidModule();
            if (moduleidModule != null) {
                moduleidModule.getProfileCollection().remove(profile);
                moduleidModule = em.merge(moduleidModule);
            }
            em.remove(profile);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Profile> findProfileEntities() {
        return findProfileEntities(true, -1, -1);
    }

    public List<Profile> findProfileEntities(int maxResults, int firstResult) {
        return findProfileEntities(false, maxResults, firstResult);
    }

    private List<Profile> findProfileEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Profile.class));
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

    public Profile findProfile(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Profile.class, id);
        } finally {
            em.close();
        }
    }

    public int getProfileCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Profile> rt = cq.from(Profile.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
