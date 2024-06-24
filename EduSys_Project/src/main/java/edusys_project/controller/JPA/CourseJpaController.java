/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edusys_project.controller.JPA;

import edusys_project.controller.JPA.exceptions.IllegalOrphanException;
import edusys_project.controller.JPA.exceptions.NonexistentEntityException;
import edusys_project.controller.JPA.exceptions.PreexistingEntityException;
import edusys_project.model.Course;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import edusys_project.model.Cycle;
import edusys_project.model.StudyPlan;
import edusys_project.model.Users;
import java.util.ArrayList;
import java.util.Collection;
import edusys_project.model.Groups;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author fcama
 */
public class CourseJpaController implements Serializable {

    public CourseJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Course course) throws PreexistingEntityException, Exception {
        if (course.getUsersCollection() == null) {
            course.setUsersCollection(new ArrayList<Users>());
        }
        if (course.getGroupsCollection() == null) {
            course.setGroupsCollection(new ArrayList<Groups>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cycle cycleidCycle = course.getCycleidCycle();
            if (cycleidCycle != null) {
                cycleidCycle = em.getReference(cycleidCycle.getClass(), cycleidCycle.getIdCycle());
                course.setCycleidCycle(cycleidCycle);
            }
            StudyPlan studyPlanidStudyPlan = course.getStudyPlanidStudyPlan();
            if (studyPlanidStudyPlan != null) {
                studyPlanidStudyPlan = em.getReference(studyPlanidStudyPlan.getClass(), studyPlanidStudyPlan.getIdStudyPlan());
                course.setStudyPlanidStudyPlan(studyPlanidStudyPlan);
            }
            Collection<Users> attachedUsersCollection = new ArrayList<Users>();
            for (Users usersCollectionUsersToAttach : course.getUsersCollection()) {
                usersCollectionUsersToAttach = em.getReference(usersCollectionUsersToAttach.getClass(), usersCollectionUsersToAttach.getIdUsers());
                attachedUsersCollection.add(usersCollectionUsersToAttach);
            }
            course.setUsersCollection(attachedUsersCollection);
            Collection<Groups> attachedGroupsCollection = new ArrayList<Groups>();
            for (Groups groupsCollectionGroupsToAttach : course.getGroupsCollection()) {
                groupsCollectionGroupsToAttach = em.getReference(groupsCollectionGroupsToAttach.getClass(), groupsCollectionGroupsToAttach.getIdGroup());
                attachedGroupsCollection.add(groupsCollectionGroupsToAttach);
            }
            course.setGroupsCollection(attachedGroupsCollection);
            em.persist(course);
            if (cycleidCycle != null) {
                cycleidCycle.getCourseCollection().add(course);
                cycleidCycle = em.merge(cycleidCycle);
            }
            if (studyPlanidStudyPlan != null) {
                studyPlanidStudyPlan.getCourseCollection().add(course);
                studyPlanidStudyPlan = em.merge(studyPlanidStudyPlan);
            }
            for (Users usersCollectionUsers : course.getUsersCollection()) {
                usersCollectionUsers.getCourseCollection().add(course);
                usersCollectionUsers = em.merge(usersCollectionUsers);
            }
            for (Groups groupsCollectionGroups : course.getGroupsCollection()) {
                Course oldCoursesyllabusOfGroupsCollectionGroups = groupsCollectionGroups.getCoursesyllabus();
                groupsCollectionGroups.setCoursesyllabus(course);
                groupsCollectionGroups = em.merge(groupsCollectionGroups);
                if (oldCoursesyllabusOfGroupsCollectionGroups != null) {
                    oldCoursesyllabusOfGroupsCollectionGroups.getGroupsCollection().remove(groupsCollectionGroups);
                    oldCoursesyllabusOfGroupsCollectionGroups = em.merge(oldCoursesyllabusOfGroupsCollectionGroups);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCourse(course.getSyllabus()) != null) {
                throw new PreexistingEntityException("Course " + course + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Course course) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Course persistentCourse = em.find(Course.class, course.getSyllabus());
            Cycle cycleidCycleOld = persistentCourse.getCycleidCycle();
            Cycle cycleidCycleNew = course.getCycleidCycle();
            StudyPlan studyPlanidStudyPlanOld = persistentCourse.getStudyPlanidStudyPlan();
            StudyPlan studyPlanidStudyPlanNew = course.getStudyPlanidStudyPlan();
            Collection<Users> usersCollectionOld = persistentCourse.getUsersCollection();
            Collection<Users> usersCollectionNew = course.getUsersCollection();
            Collection<Groups> groupsCollectionOld = persistentCourse.getGroupsCollection();
            Collection<Groups> groupsCollectionNew = course.getGroupsCollection();
            List<String> illegalOrphanMessages = null;
            for (Groups groupsCollectionOldGroups : groupsCollectionOld) {
                if (!groupsCollectionNew.contains(groupsCollectionOldGroups)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Groups " + groupsCollectionOldGroups + " since its coursesyllabus field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (cycleidCycleNew != null) {
                cycleidCycleNew = em.getReference(cycleidCycleNew.getClass(), cycleidCycleNew.getIdCycle());
                course.setCycleidCycle(cycleidCycleNew);
            }
            if (studyPlanidStudyPlanNew != null) {
                studyPlanidStudyPlanNew = em.getReference(studyPlanidStudyPlanNew.getClass(), studyPlanidStudyPlanNew.getIdStudyPlan());
                course.setStudyPlanidStudyPlan(studyPlanidStudyPlanNew);
            }
            Collection<Users> attachedUsersCollectionNew = new ArrayList<Users>();
            for (Users usersCollectionNewUsersToAttach : usersCollectionNew) {
                usersCollectionNewUsersToAttach = em.getReference(usersCollectionNewUsersToAttach.getClass(), usersCollectionNewUsersToAttach.getIdUsers());
                attachedUsersCollectionNew.add(usersCollectionNewUsersToAttach);
            }
            usersCollectionNew = attachedUsersCollectionNew;
            course.setUsersCollection(usersCollectionNew);
            Collection<Groups> attachedGroupsCollectionNew = new ArrayList<Groups>();
            for (Groups groupsCollectionNewGroupsToAttach : groupsCollectionNew) {
                groupsCollectionNewGroupsToAttach = em.getReference(groupsCollectionNewGroupsToAttach.getClass(), groupsCollectionNewGroupsToAttach.getIdGroup());
                attachedGroupsCollectionNew.add(groupsCollectionNewGroupsToAttach);
            }
            groupsCollectionNew = attachedGroupsCollectionNew;
            course.setGroupsCollection(groupsCollectionNew);
            course = em.merge(course);
            if (cycleidCycleOld != null && !cycleidCycleOld.equals(cycleidCycleNew)) {
                cycleidCycleOld.getCourseCollection().remove(course);
                cycleidCycleOld = em.merge(cycleidCycleOld);
            }
            if (cycleidCycleNew != null && !cycleidCycleNew.equals(cycleidCycleOld)) {
                cycleidCycleNew.getCourseCollection().add(course);
                cycleidCycleNew = em.merge(cycleidCycleNew);
            }
            if (studyPlanidStudyPlanOld != null && !studyPlanidStudyPlanOld.equals(studyPlanidStudyPlanNew)) {
                studyPlanidStudyPlanOld.getCourseCollection().remove(course);
                studyPlanidStudyPlanOld = em.merge(studyPlanidStudyPlanOld);
            }
            if (studyPlanidStudyPlanNew != null && !studyPlanidStudyPlanNew.equals(studyPlanidStudyPlanOld)) {
                studyPlanidStudyPlanNew.getCourseCollection().add(course);
                studyPlanidStudyPlanNew = em.merge(studyPlanidStudyPlanNew);
            }
            for (Users usersCollectionOldUsers : usersCollectionOld) {
                if (!usersCollectionNew.contains(usersCollectionOldUsers)) {
                    usersCollectionOldUsers.getCourseCollection().remove(course);
                    usersCollectionOldUsers = em.merge(usersCollectionOldUsers);
                }
            }
            for (Users usersCollectionNewUsers : usersCollectionNew) {
                if (!usersCollectionOld.contains(usersCollectionNewUsers)) {
                    usersCollectionNewUsers.getCourseCollection().add(course);
                    usersCollectionNewUsers = em.merge(usersCollectionNewUsers);
                }
            }
            for (Groups groupsCollectionNewGroups : groupsCollectionNew) {
                if (!groupsCollectionOld.contains(groupsCollectionNewGroups)) {
                    Course oldCoursesyllabusOfGroupsCollectionNewGroups = groupsCollectionNewGroups.getCoursesyllabus();
                    groupsCollectionNewGroups.setCoursesyllabus(course);
                    groupsCollectionNewGroups = em.merge(groupsCollectionNewGroups);
                    if (oldCoursesyllabusOfGroupsCollectionNewGroups != null && !oldCoursesyllabusOfGroupsCollectionNewGroups.equals(course)) {
                        oldCoursesyllabusOfGroupsCollectionNewGroups.getGroupsCollection().remove(groupsCollectionNewGroups);
                        oldCoursesyllabusOfGroupsCollectionNewGroups = em.merge(oldCoursesyllabusOfGroupsCollectionNewGroups);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = course.getSyllabus();
                if (findCourse(id) == null) {
                    throw new NonexistentEntityException("The course with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Course course;
            try {
                course = em.getReference(Course.class, id);
                course.getSyllabus();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The course with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Groups> groupsCollectionOrphanCheck = course.getGroupsCollection();
            for (Groups groupsCollectionOrphanCheckGroups : groupsCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Course (" + course + ") cannot be destroyed since the Groups " + groupsCollectionOrphanCheckGroups + " in its groupsCollection field has a non-nullable coursesyllabus field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Cycle cycleidCycle = course.getCycleidCycle();
            if (cycleidCycle != null) {
                cycleidCycle.getCourseCollection().remove(course);
                cycleidCycle = em.merge(cycleidCycle);
            }
            StudyPlan studyPlanidStudyPlan = course.getStudyPlanidStudyPlan();
            if (studyPlanidStudyPlan != null) {
                studyPlanidStudyPlan.getCourseCollection().remove(course);
                studyPlanidStudyPlan = em.merge(studyPlanidStudyPlan);
            }
            Collection<Users> usersCollection = course.getUsersCollection();
            for (Users usersCollectionUsers : usersCollection) {
                usersCollectionUsers.getCourseCollection().remove(course);
                usersCollectionUsers = em.merge(usersCollectionUsers);
            }
            em.remove(course);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

//    public List<Course> findCourseEntities() {
//        return findCourseEntities(true, -1, -1);
//    }
//
//    public List<Course> findCourseEntities(int maxResults, int firstResult) {
//        return findCourseEntities(false, maxResults, firstResult);
//    }
//
//    private List<Course> findCourseEntities(boolean all, int maxResults, int firstResult) {
//        EntityManager em = getEntityManager();
//        try {
//            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
//            cq.select(cq.from(Course.class));
//            Query q = em.createQuery(cq);
//            if (!all) {
//                q.setMaxResults(maxResults);
//                q.setFirstResult(firstResult);
//            }
//            return q.getResultList();
//        } finally {
//            em.close();
//        }
//    }
    
    public List<Course> consultList() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery<Course> cq = em.getCriteriaBuilder().createQuery(Course.class);
            cq.select(cq.from(Course.class));
            TypedQuery<Course> query = em.createQuery(cq);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public Course findCourse(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Course.class, id);
        } finally {
            em.close();
        }
    }

    public int getCourseCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Course> rt = cq.from(Course.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
