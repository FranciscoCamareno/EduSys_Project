/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edusys_project.controller.JPA;

import edusys_project.controller.JPA.exceptions.IllegalOrphanException;
import edusys_project.controller.JPA.exceptions.NonexistentEntityException;
import edusys_project.controller.JPA.exceptions.PreexistingEntityException;
import edusys_project.model.Modulo;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import edusys_project.model.Profile;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author fcama
 */
public class ModuleJpaController implements Serializable {

    public ModuleJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Modulo module) throws PreexistingEntityException, Exception {
        if (module.getProfileCollection() == null) {
            module.setProfileCollection(new ArrayList<Profile>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Profile> attachedProfileCollection = new ArrayList<Profile>();
            for (Profile profileCollectionProfileToAttach : module.getProfileCollection()) {
                profileCollectionProfileToAttach = em.getReference(profileCollectionProfileToAttach.getClass(), profileCollectionProfileToAttach.getIdProfile());
                attachedProfileCollection.add(profileCollectionProfileToAttach);
            }
            module.setProfileCollection(attachedProfileCollection);
            em.persist(module);
            for (Profile profileCollectionProfile : module.getProfileCollection()) {
                Modulo oldModuleidModuleOfProfileCollectionProfile = profileCollectionProfile.getModuleidModule();
                profileCollectionProfile.setModuleidModule(module);
                profileCollectionProfile = em.merge(profileCollectionProfile);
                if (oldModuleidModuleOfProfileCollectionProfile != null) {
                    oldModuleidModuleOfProfileCollectionProfile.getProfileCollection().remove(profileCollectionProfile);
                    oldModuleidModuleOfProfileCollectionProfile = em.merge(oldModuleidModuleOfProfileCollectionProfile);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findModule(module.getIdModule()) != null) {
                throw new PreexistingEntityException("Module " + module + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Modulo module) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Modulo persistentModule = em.find(Modulo.class, module.getIdModule());
            Collection<Profile> profileCollectionOld = persistentModule.getProfileCollection();
            Collection<Profile> profileCollectionNew = module.getProfileCollection();
            List<String> illegalOrphanMessages = null;
            for (Profile profileCollectionOldProfile : profileCollectionOld) {
                if (!profileCollectionNew.contains(profileCollectionOldProfile)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Profile " + profileCollectionOldProfile + " since its moduleidModule field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Profile> attachedProfileCollectionNew = new ArrayList<Profile>();
            for (Profile profileCollectionNewProfileToAttach : profileCollectionNew) {
                profileCollectionNewProfileToAttach = em.getReference(profileCollectionNewProfileToAttach.getClass(), profileCollectionNewProfileToAttach.getIdProfile());
                attachedProfileCollectionNew.add(profileCollectionNewProfileToAttach);
            }
            profileCollectionNew = attachedProfileCollectionNew;
            module.setProfileCollection(profileCollectionNew);
            module = em.merge(module);
            for (Profile profileCollectionNewProfile : profileCollectionNew) {
                if (!profileCollectionOld.contains(profileCollectionNewProfile)) {
                    Modulo oldModuleidModuleOfProfileCollectionNewProfile = profileCollectionNewProfile.getModuleidModule();
                    profileCollectionNewProfile.setModuleidModule(module);
                    profileCollectionNewProfile = em.merge(profileCollectionNewProfile);
                    if (oldModuleidModuleOfProfileCollectionNewProfile != null && !oldModuleidModuleOfProfileCollectionNewProfile.equals(module)) {
                        oldModuleidModuleOfProfileCollectionNewProfile.getProfileCollection().remove(profileCollectionNewProfile);
                        oldModuleidModuleOfProfileCollectionNewProfile = em.merge(oldModuleidModuleOfProfileCollectionNewProfile);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = module.getIdModule();
                if (findModule(id) == null) {
                    throw new NonexistentEntityException("The module with id " + id + " no longer exists.");
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
            Modulo module;
            try {
                module = em.getReference(Modulo.class, id);
                module.getIdModule();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The module with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Profile> profileCollectionOrphanCheck = module.getProfileCollection();
            for (Profile profileCollectionOrphanCheckProfile : profileCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Module (" + module + ") cannot be destroyed since the Profile " + profileCollectionOrphanCheckProfile + " in its profileCollection field has a non-nullable moduleidModule field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(module);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Modulo> findModuleEntities() {
        return findModuleEntities(true, -1, -1);
    }

    public List<Modulo> findModuleEntities(int maxResults, int firstResult) {
        return findModuleEntities(false, maxResults, firstResult);
    }

    private List<Modulo> findModuleEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Modulo.class));
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

    public Modulo findModule(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Modulo.class, id);
        } finally {
            em.close();
        }
    }

    public int getModuleCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Modulo> rt = cq.from(Modulo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
