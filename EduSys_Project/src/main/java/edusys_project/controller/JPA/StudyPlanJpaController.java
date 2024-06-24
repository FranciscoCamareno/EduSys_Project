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
import edusys_project.model.Careers;
import java.util.ArrayList;
import java.util.Collection;
import edusys_project.model.Course;
import edusys_project.model.StudyPlan;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author fcama
 */
public class StudyPlanJpaController implements Serializable {

    private EntityManagerFactory emf = null;

    public StudyPlanJpaController(EntityManagerFactory emf) {
        this.emf = Persistence.createEntityManagerFactory("EduSysPersistence");
    }
    
    public StudyPlanJpaController() {
        this.emf = Persistence.createEntityManagerFactory("EduSysPersistence");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    

    public void create(StudyPlan studyPlan) throws PreexistingEntityException, Exception {
        if (studyPlan.getCareersCollection() == null) {
            studyPlan.setCareersCollection(new ArrayList<Careers>());
        }
        if (studyPlan.getCourseCollection() == null) {
            studyPlan.setCourseCollection(new ArrayList<Course>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();//crear admin de entidades
            em.getTransaction().begin();//preparar la transaccion
            Collection<Careers> attachedCareersCollection = new ArrayList<Careers>();
            for (Careers careersCollectionCareersToAttach : studyPlan.getCareersCollection()) {
                careersCollectionCareersToAttach = em.getReference(careersCollectionCareersToAttach.getClass(), careersCollectionCareersToAttach.getCode());
                attachedCareersCollection.add(careersCollectionCareersToAttach);
            }
            studyPlan.setCareersCollection(attachedCareersCollection);
            Collection<Course> attachedCourseCollection = new ArrayList<Course>();
            for (Course courseCollectionCourseToAttach : studyPlan.getCourseCollection()) {
                courseCollectionCourseToAttach = em.getReference(courseCollectionCourseToAttach.getClass(), courseCollectionCourseToAttach.getSyllabus());
                attachedCourseCollection.add(courseCollectionCourseToAttach);
            }
            studyPlan.setCourseCollection(attachedCourseCollection);
            em.persist(studyPlan);//insertar una entidad en la base de datos
            for (Careers careersCollectionCareers : studyPlan.getCareersCollection()) {
                StudyPlan oldStudyPlanidStudyPlanOfCareersCollectionCareers = careersCollectionCareers.getStudyPlanidStudyPlan();
                careersCollectionCareers.setStudyPlanidStudyPlan(studyPlan);
                careersCollectionCareers = em.merge(careersCollectionCareers);
                if (oldStudyPlanidStudyPlanOfCareersCollectionCareers != null) {
                    oldStudyPlanidStudyPlanOfCareersCollectionCareers.getCareersCollection().remove(careersCollectionCareers);
                    oldStudyPlanidStudyPlanOfCareersCollectionCareers = em.merge(oldStudyPlanidStudyPlanOfCareersCollectionCareers);
                }
            }
            for (Course courseCollectionCourse : studyPlan.getCourseCollection()) {
                StudyPlan oldStudyPlanidStudyPlanOfCourseCollectionCourse = courseCollectionCourse.getStudyPlanidStudyPlan();
                courseCollectionCourse.setStudyPlanidStudyPlan(studyPlan);
                courseCollectionCourse = em.merge(courseCollectionCourse);
                if (oldStudyPlanidStudyPlanOfCourseCollectionCourse != null) {
                    oldStudyPlanidStudyPlanOfCourseCollectionCourse.getCourseCollection().remove(courseCollectionCourse);
                    oldStudyPlanidStudyPlanOfCourseCollectionCourse = em.merge(oldStudyPlanidStudyPlanOfCourseCollectionCourse);
                }
            }
            em.getTransaction().commit();//finalizar la transaccion
        } catch (Exception ex) {
            if (findStudyPlan(studyPlan.getIdStudyPlan()) != null) {
                throw new PreexistingEntityException("StudyPlan " + studyPlan + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();//cerrar entity manager
            }
        }
    }

//    public void edit(StudyPlan studyPlan) throws IllegalOrphanException, NonexistentEntityException, Exception {
//        EntityManager em = null;
//        try {
//            em = getEntityManager();
//            em.getTransaction().begin();
//            StudyPlan persistentStudyPlan = em.find(StudyPlan.class, studyPlan.getIdStudyPlan());
//            Collection<Careers> careersCollectionOld = persistentStudyPlan.getCareersCollection();
//            Collection<Careers> careersCollectionNew = studyPlan.getCareersCollection();
//            Collection<Course> courseCollectionOld = persistentStudyPlan.getCourseCollection();
//            Collection<Course> courseCollectionNew = studyPlan.getCourseCollection();
//            List<String> illegalOrphanMessages = null;
//            for (Careers careersCollectionOldCareers : careersCollectionOld) {
//                if (!careersCollectionNew.contains(careersCollectionOldCareers)) {
//                    if (illegalOrphanMessages == null) {
//                        illegalOrphanMessages = new ArrayList<String>();
//                    }
//                    illegalOrphanMessages.add("You must retain Careers " + careersCollectionOldCareers + " since its studyPlanidStudyPlan field is not nullable.");
//                }
//            }
//            for (Course courseCollectionOldCourse : courseCollectionOld) {
//                if (!courseCollectionNew.contains(courseCollectionOldCourse)) {
//                    if (illegalOrphanMessages == null) {
//                        illegalOrphanMessages = new ArrayList<String>();
//                    }
//                    illegalOrphanMessages.add("You must retain Course " + courseCollectionOldCourse + " since its studyPlanidStudyPlan field is not nullable.");
//                }
//            }
//            if (illegalOrphanMessages != null) {
//                throw new IllegalOrphanException(illegalOrphanMessages);
//            }
//            Collection<Careers> attachedCareersCollectionNew = new ArrayList<Careers>();
//            for (Careers careersCollectionNewCareersToAttach : careersCollectionNew) {
//                careersCollectionNewCareersToAttach = em.getReference(careersCollectionNewCareersToAttach.getClass(), careersCollectionNewCareersToAttach.getCode());
//                attachedCareersCollectionNew.add(careersCollectionNewCareersToAttach);
//            }
//            careersCollectionNew = attachedCareersCollectionNew;
//            studyPlan.setCareersCollection(careersCollectionNew);
//            Collection<Course> attachedCourseCollectionNew = new ArrayList<Course>();
//            for (Course courseCollectionNewCourseToAttach : courseCollectionNew) {
//                courseCollectionNewCourseToAttach = em.getReference(courseCollectionNewCourseToAttach.getClass(), courseCollectionNewCourseToAttach.getSyllabus());
//                attachedCourseCollectionNew.add(courseCollectionNewCourseToAttach);
//            }
//            courseCollectionNew = attachedCourseCollectionNew;
//            studyPlan.setCourseCollection(courseCollectionNew);
//            studyPlan = em.merge(studyPlan);
//            for (Careers careersCollectionNewCareers : careersCollectionNew) {
//                if (!careersCollectionOld.contains(careersCollectionNewCareers)) {
//                    StudyPlan oldStudyPlanidStudyPlanOfCareersCollectionNewCareers = careersCollectionNewCareers.getStudyPlanidStudyPlan();
//                    careersCollectionNewCareers.setStudyPlanidStudyPlan(studyPlan);
//                    careersCollectionNewCareers = em.merge(careersCollectionNewCareers);
//                    if (oldStudyPlanidStudyPlanOfCareersCollectionNewCareers != null && !oldStudyPlanidStudyPlanOfCareersCollectionNewCareers.equals(studyPlan)) {
//                        oldStudyPlanidStudyPlanOfCareersCollectionNewCareers.getCareersCollection().remove(careersCollectionNewCareers);
//                        oldStudyPlanidStudyPlanOfCareersCollectionNewCareers = em.merge(oldStudyPlanidStudyPlanOfCareersCollectionNewCareers);
//                    }
//                }
//            }
//            for (Course courseCollectionNewCourse : courseCollectionNew) {
//                if (!courseCollectionOld.contains(courseCollectionNewCourse)) {
//                    StudyPlan oldStudyPlanidStudyPlanOfCourseCollectionNewCourse = courseCollectionNewCourse.getStudyPlanidStudyPlan();
//                    courseCollectionNewCourse.setStudyPlanidStudyPlan(studyPlan);
//                    courseCollectionNewCourse = em.merge(courseCollectionNewCourse);
//                    if (oldStudyPlanidStudyPlanOfCourseCollectionNewCourse != null && !oldStudyPlanidStudyPlanOfCourseCollectionNewCourse.equals(studyPlan)) {
//                        oldStudyPlanidStudyPlanOfCourseCollectionNewCourse.getCourseCollection().remove(courseCollectionNewCourse);
//                        oldStudyPlanidStudyPlanOfCourseCollectionNewCourse = em.merge(oldStudyPlanidStudyPlanOfCourseCollectionNewCourse);
//                    }
//                }
//            }
//            em.getTransaction().commit();
//        } catch (Exception ex) {
//            String msg = ex.getLocalizedMessage();
//            if (msg == null || msg.length() == 0) {
//                Integer id = studyPlan.getIdStudyPlan();
//                if (findStudyPlan(id) == null) {
//                    throw new NonexistentEntityException("The studyPlan with id " + id + " no longer exists.");
//                }
//            }
//            throw ex;
//        } finally {
//            if (em != null) {
//                em.close();
//            }
//        }
//    }
    public void editar(StudyPlan studyPlan) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();

            StudyPlan persistentStudyPlan = em.find(StudyPlan.class, studyPlan.getIdStudyPlan());

            Collection<Careers> careersCollectionNew = studyPlan.getCareersCollection();
            Collection<Course> courseCollectionNew = studyPlan.getCourseCollection();

            studyPlan.setCareersCollection(null); // Avoid modifications to Careers
            studyPlan.setCourseCollection(null);   // Avoid modifications to Course

            studyPlan = em.merge(studyPlan);  // Merge only StudyPlan

            // Update relationships with Careers and Course separately (if needed)
            updateCareers(em, persistentStudyPlan, careersCollectionNew);
            updateCourses(em, persistentStudyPlan, courseCollectionNew);

            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = studyPlan.getIdStudyPlan();
                if (findStudyPlan(id) == null) {
                    throw new NonexistentEntityException("The studyPlan with id " + id + " no longer exists.");
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
            StudyPlan studyPlan;
            try {
                studyPlan = em.getReference(StudyPlan.class, id);
                studyPlan.getIdStudyPlan();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The studyPlan with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Careers> careersCollectionOrphanCheck = studyPlan.getCareersCollection();
            for (Careers careersCollectionOrphanCheckCareers : careersCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This StudyPlan (" + studyPlan + ") cannot be destroyed since the Careers " + careersCollectionOrphanCheckCareers + " in its careersCollection field has a non-nullable studyPlanidStudyPlan field.");
            }
            Collection<Course> courseCollectionOrphanCheck = studyPlan.getCourseCollection();
            for (Course courseCollectionOrphanCheckCourse : courseCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This StudyPlan (" + studyPlan + ") cannot be destroyed since the Course " + courseCollectionOrphanCheckCourse + " in its courseCollection field has a non-nullable studyPlanidStudyPlan field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(studyPlan);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<StudyPlan> findStudyPlanEntities() {
        return findStudyPlanEntities(true, -1, -1);
    }

    public List<StudyPlan> findStudyPlanEntities(int maxResults, int firstResult) {
        return findStudyPlanEntities(false, maxResults, firstResult);
    }

    private List<StudyPlan> findStudyPlanEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(StudyPlan.class));
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

    public StudyPlan findStudyPlan(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(StudyPlan.class, id);
        } finally {
            em.close();
        }
    }

    public int getStudyPlanCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<StudyPlan> rt = cq.from(StudyPlan.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<StudyPlan> consultList() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery<StudyPlan> cq = em.getCriteriaBuilder().createQuery(StudyPlan.class);
            cq.select(cq.from(StudyPlan.class));
            TypedQuery<StudyPlan> query = em.createQuery(cq);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    private void updateCareers(EntityManager em, StudyPlan persistentStudyPlan, Collection<Careers> careersCollectionNew) {
        
    }

    private void updateCourses(EntityManager em, StudyPlan persistentStudyPlan, Collection<Course> courseCollectionNew) {
    }

}
