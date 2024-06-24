/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edusys_project.controller.JPA;

import edusys_project.controller.JPA.exceptions.IllegalOrphanException;
import edusys_project.controller.JPA.exceptions.NonexistentEntityException;
import edusys_project.controller.JPA.exceptions.PreexistingEntityException;
import edusys_project.model.Careers;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import edusys_project.model.StudyPlan;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author fcama
 */
public class CareersJpaController implements Serializable {

    private EntityManagerFactory emf = null;
    
    public CareersJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Careers careers) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            StudyPlan studyPlanidStudyPlan = careers.getStudyPlanidStudyPlan();
            if (studyPlanidStudyPlan != null) {
                studyPlanidStudyPlan = em.getReference(studyPlanidStudyPlan.getClass(), studyPlanidStudyPlan.getIdStudyPlan());
                careers.setStudyPlanidStudyPlan(studyPlanidStudyPlan);
            }
            em.persist(careers);
            if (studyPlanidStudyPlan != null) {
                studyPlanidStudyPlan.getCareersCollection().add(careers);
                studyPlanidStudyPlan = em.merge(studyPlanidStudyPlan);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCareers(careers.getCode()) != null) {
                throw new PreexistingEntityException("Careers " + careers + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Careers careers) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            
            Careers persistentCareers = em.find(Careers.class, careers.getCode());
            
            persistentCareers.setCode(careers.getCode());
            persistentCareers.setName(careers.getName());
            persistentCareers.setDescription(careers.getDescription());
            persistentCareers.setProfProfile(careers.getProfProfile());
            persistentCareers.setWorkingMarket(careers.getWorkingMarket());
            
            em.merge(persistentCareers);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = careers.getCode();
                if (findCareers(id) == null) {
                    throw new NonexistentEntityException("The careers with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException, IllegalOrphanException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Careers careers;
            try {
                careers = em.getReference(Careers.class, id);
                careers.getCode();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The careers with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            StudyPlan studyPlanidStudyPlan = careers.getStudyPlanidStudyPlan();
            if (studyPlanidStudyPlan != null) {
                studyPlanidStudyPlan.getCareersCollection().remove(careers);
                studyPlanidStudyPlan = em.merge(studyPlanidStudyPlan);
            }
            em.remove(careers);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Careers> findCareersEntities() {
        return findCareersEntities(true, -1, -1);
    }

    public List<Careers> findCareersEntities(int maxResults, int firstResult) {
        return findCareersEntities(false, maxResults, firstResult);
    }

    private List<Careers> findCareersEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Careers.class));
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
    
    public List<Careers> consultList() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery<Careers> cq = em.getCriteriaBuilder().createQuery(Careers.class);
            cq.select(cq.from(Careers.class));
            TypedQuery<Careers> query = em.createQuery(cq);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public Careers findCareers(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Careers.class, id);
        } finally {
            em.close();
        }
    }

    public int getCareersCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Careers> rt = cq.from(Careers.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
