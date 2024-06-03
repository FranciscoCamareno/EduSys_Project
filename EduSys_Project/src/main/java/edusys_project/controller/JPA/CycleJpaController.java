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
import edusys_project.model.Course;
import edusys_project.model.Cycle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author fcama
 */
public class CycleJpaController implements Serializable {

    public CycleJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cycle cycle) throws PreexistingEntityException, Exception {
        if (cycle.getCourseCollection() == null) {
            cycle.setCourseCollection(new ArrayList<Course>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Course> attachedCourseCollection = new ArrayList<Course>();
            for (Course courseCollectionCourseToAttach : cycle.getCourseCollection()) {
                courseCollectionCourseToAttach = em.getReference(courseCollectionCourseToAttach.getClass(), courseCollectionCourseToAttach.getSyllabus());
                attachedCourseCollection.add(courseCollectionCourseToAttach);
            }
            cycle.setCourseCollection(attachedCourseCollection);
            em.persist(cycle);
            for (Course courseCollectionCourse : cycle.getCourseCollection()) {
                Cycle oldCycleidCycleOfCourseCollectionCourse = courseCollectionCourse.getCycleidCycle();
                courseCollectionCourse.setCycleidCycle(cycle);
                courseCollectionCourse = em.merge(courseCollectionCourse);
                if (oldCycleidCycleOfCourseCollectionCourse != null) {
                    oldCycleidCycleOfCourseCollectionCourse.getCourseCollection().remove(courseCollectionCourse);
                    oldCycleidCycleOfCourseCollectionCourse = em.merge(oldCycleidCycleOfCourseCollectionCourse);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCycle(cycle.getIdCycle()) != null) {
                throw new PreexistingEntityException("Cycle " + cycle + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cycle cycle) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cycle persistentCycle = em.find(Cycle.class, cycle.getIdCycle());
            Collection<Course> courseCollectionOld = persistentCycle.getCourseCollection();
            Collection<Course> courseCollectionNew = cycle.getCourseCollection();
            List<String> illegalOrphanMessages = null;
            for (Course courseCollectionOldCourse : courseCollectionOld) {
                if (!courseCollectionNew.contains(courseCollectionOldCourse)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Course " + courseCollectionOldCourse + " since its cycleidCycle field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Course> attachedCourseCollectionNew = new ArrayList<Course>();
            for (Course courseCollectionNewCourseToAttach : courseCollectionNew) {
                courseCollectionNewCourseToAttach = em.getReference(courseCollectionNewCourseToAttach.getClass(), courseCollectionNewCourseToAttach.getSyllabus());
                attachedCourseCollectionNew.add(courseCollectionNewCourseToAttach);
            }
            courseCollectionNew = attachedCourseCollectionNew;
            cycle.setCourseCollection(courseCollectionNew);
            cycle = em.merge(cycle);
            for (Course courseCollectionNewCourse : courseCollectionNew) {
                if (!courseCollectionOld.contains(courseCollectionNewCourse)) {
                    Cycle oldCycleidCycleOfCourseCollectionNewCourse = courseCollectionNewCourse.getCycleidCycle();
                    courseCollectionNewCourse.setCycleidCycle(cycle);
                    courseCollectionNewCourse = em.merge(courseCollectionNewCourse);
                    if (oldCycleidCycleOfCourseCollectionNewCourse != null && !oldCycleidCycleOfCourseCollectionNewCourse.equals(cycle)) {
                        oldCycleidCycleOfCourseCollectionNewCourse.getCourseCollection().remove(courseCollectionNewCourse);
                        oldCycleidCycleOfCourseCollectionNewCourse = em.merge(oldCycleidCycleOfCourseCollectionNewCourse);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = cycle.getIdCycle();
                if (findCycle(id) == null) {
                    throw new NonexistentEntityException("The cycle with id " + id + " no longer exists.");
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
            Cycle cycle;
            try {
                cycle = em.getReference(Cycle.class, id);
                cycle.getIdCycle();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cycle with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Course> courseCollectionOrphanCheck = cycle.getCourseCollection();
            for (Course courseCollectionOrphanCheckCourse : courseCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Cycle (" + cycle + ") cannot be destroyed since the Course " + courseCollectionOrphanCheckCourse + " in its courseCollection field has a non-nullable cycleidCycle field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(cycle);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cycle> findCycleEntities() {
        return findCycleEntities(true, -1, -1);
    }

    public List<Cycle> findCycleEntities(int maxResults, int firstResult) {
        return findCycleEntities(false, maxResults, firstResult);
    }

    private List<Cycle> findCycleEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cycle.class));
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

    public Cycle findCycle(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cycle.class, id);
        } finally {
            em.close();
        }
    }

    public int getCycleCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cycle> rt = cq.from(Cycle.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
