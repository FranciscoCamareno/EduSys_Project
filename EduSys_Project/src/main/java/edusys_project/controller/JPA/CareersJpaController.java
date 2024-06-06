/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edusys_project.controller.JPA;

import edusys_project.controller.JPA.exceptions.NonexistentEntityException;
import edusys_project.controller.JPA.exceptions.PreexistingEntityException;
import edusys_project.model.Careers;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import edusys_project.model.StudyPlan;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author fcama
 */
public class CareersJpaController implements Serializable {

    public CareersJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

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

    public void edit(Careers careers) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Careers persistentCareers = em.find(Careers.class, careers.getCode());
            StudyPlan studyPlanidStudyPlanOld = persistentCareers.getStudyPlanidStudyPlan();
            StudyPlan studyPlanidStudyPlanNew = careers.getStudyPlanidStudyPlan();
            if (studyPlanidStudyPlanNew != null) {
                studyPlanidStudyPlanNew = em.getReference(studyPlanidStudyPlanNew.getClass(), studyPlanidStudyPlanNew.getIdStudyPlan());
                careers.setStudyPlanidStudyPlan(studyPlanidStudyPlanNew);
            }
            careers = em.merge(careers);
            if (studyPlanidStudyPlanOld != null && !studyPlanidStudyPlanOld.equals(studyPlanidStudyPlanNew)) {
                studyPlanidStudyPlanOld.getCareersCollection().remove(careers);
                studyPlanidStudyPlanOld = em.merge(studyPlanidStudyPlanOld);
            }
            if (studyPlanidStudyPlanNew != null && !studyPlanidStudyPlanNew.equals(studyPlanidStudyPlanOld)) {
                studyPlanidStudyPlanNew.getCareersCollection().add(careers);
                studyPlanidStudyPlanNew = em.merge(studyPlanidStudyPlanNew);
            }
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

    public void destroy(String id) throws NonexistentEntityException {
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
