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
import edusys_project.model.Profile;
import edusys_project.model.Activities;
import java.util.ArrayList;
import java.util.Collection;
import edusys_project.model.Course;
import edusys_project.model.Notifications;
import edusys_project.model.Groups;
import edusys_project.model.Student;
import edusys_project.model.Users;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author fcama
 */
public class UsersJpaController implements Serializable {

    private EntityManagerFactory emf = null;

    public UsersJpaController(EntityManagerFactory emf) {
        this.emf = emf;
        //Persistence.createEntityManagerFactory("EduSysPersistence");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Users users) throws PreexistingEntityException, Exception {
        if (users.getActivitiesCollection() == null) {
            users.setActivitiesCollection(new ArrayList<Activities>());
        }
        if (users.getCourseCollection() == null) {
            users.setCourseCollection(new ArrayList<Course>());
        }
        if (users.getNotificationsCollection() == null) {
            users.setNotificationsCollection(new ArrayList<Notifications>());
        }
        if (users.getGroupsCollection() == null) {
            users.setGroupsCollection(new ArrayList<Groups>());
        }
        if (users.getStudentCollection() == null) {
            users.setStudentCollection(new ArrayList<Student>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager(); //crea el administrador de entidades
            em.getTransaction().begin(); //prepara la transaccion
            Profile profileidProfile = users.getProfileidProfile();
            if (profileidProfile != null) {
                profileidProfile = em.getReference(profileidProfile.getClass(), profileidProfile.getIdProfile());
                users.setProfileidProfile(profileidProfile);
            }
            Collection<Activities> attachedActivitiesCollection = new ArrayList<Activities>();
            for (Activities activitiesCollectionActivitiesToAttach : users.getActivitiesCollection()) {
                activitiesCollectionActivitiesToAttach = em.getReference(activitiesCollectionActivitiesToAttach.getClass(), activitiesCollectionActivitiesToAttach.getIdActivities());
                attachedActivitiesCollection.add(activitiesCollectionActivitiesToAttach);
            }
            users.setActivitiesCollection(attachedActivitiesCollection);
            Collection<Course> attachedCourseCollection = new ArrayList<Course>();
            for (Course courseCollectionCourseToAttach : users.getCourseCollection()) {
                courseCollectionCourseToAttach = em.getReference(courseCollectionCourseToAttach.getClass(), courseCollectionCourseToAttach.getSyllabus());
                attachedCourseCollection.add(courseCollectionCourseToAttach);
            }
            users.setCourseCollection(attachedCourseCollection);
            Collection<Notifications> attachedNotificationsCollection = new ArrayList<Notifications>();
            for (Notifications notificationsCollectionNotificationsToAttach : users.getNotificationsCollection()) {
                notificationsCollectionNotificationsToAttach = em.getReference(notificationsCollectionNotificationsToAttach.getClass(), notificationsCollectionNotificationsToAttach.getIdNotifications());
                attachedNotificationsCollection.add(notificationsCollectionNotificationsToAttach);
            }
            users.setNotificationsCollection(attachedNotificationsCollection);
            Collection<Groups> attachedGroupsCollection = new ArrayList<Groups>();
            for (Groups groupsCollectionGroupsToAttach : users.getGroupsCollection()) {
                groupsCollectionGroupsToAttach = em.getReference(groupsCollectionGroupsToAttach.getClass(), groupsCollectionGroupsToAttach.getIdGroup());
                attachedGroupsCollection.add(groupsCollectionGroupsToAttach);
            }
            users.setGroupsCollection(attachedGroupsCollection);
            Collection<Student> attachedStudentCollection = new ArrayList<Student>();
            for (Student studentCollectionStudentToAttach : users.getStudentCollection()) {
                studentCollectionStudentToAttach = em.getReference(studentCollectionStudentToAttach.getClass(), studentCollectionStudentToAttach.getStudentPK());
                attachedStudentCollection.add(studentCollectionStudentToAttach);
            }
            users.setStudentCollection(attachedStudentCollection);
            em.persist(users);//inserta entidad en la base de datos
            if (profileidProfile != null) {
                profileidProfile.getUsersCollection().add(users);
                profileidProfile = em.merge(profileidProfile);
            }
            for (Activities activitiesCollectionActivities : users.getActivitiesCollection()) {
                activitiesCollectionActivities.getUsersCollection().add(users);
                activitiesCollectionActivities = em.merge(activitiesCollectionActivities);
            }
            for (Course courseCollectionCourse : users.getCourseCollection()) {
                courseCollectionCourse.getUsersCollection().add(users);
                courseCollectionCourse = em.merge(courseCollectionCourse);
            }
            for (Notifications notificationsCollectionNotifications : users.getNotificationsCollection()) {
                notificationsCollectionNotifications.getUsersCollection().add(users);
                notificationsCollectionNotifications = em.merge(notificationsCollectionNotifications);
            }
            for (Groups groupsCollectionGroups : users.getGroupsCollection()) {
                groupsCollectionGroups.getUsersCollection().add(users);
                groupsCollectionGroups = em.merge(groupsCollectionGroups);
            }
            for (Student studentCollectionStudent : users.getStudentCollection()) {
                Users oldUsersOfStudentCollectionStudent = studentCollectionStudent.getUsers();
                studentCollectionStudent.setUsers(users);
                studentCollectionStudent = em.merge(studentCollectionStudent);
                if (oldUsersOfStudentCollectionStudent != null) {
                    oldUsersOfStudentCollectionStudent.getStudentCollection().remove(studentCollectionStudent);
                    oldUsersOfStudentCollectionStudent = em.merge(oldUsersOfStudentCollectionStudent);
                }
            }
            em.getTransaction().commit(); //finalizar transaccion
        } catch (Exception ex) {
            if (findUsers(users.getIdUsers()) != null) {
                throw new PreexistingEntityException("Users " + users + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    //metodo editar
    public void edit(Users users) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Users persistentUsers = em.find(Users.class, users.getIdUsers());
            Profile profileidProfileOld = persistentUsers.getProfileidProfile();
            Profile profileidProfileNew = users.getProfileidProfile();
            Collection<Activities> activitiesCollectionOld = persistentUsers.getActivitiesCollection();
            Collection<Activities> activitiesCollectionNew = users.getActivitiesCollection();
            Collection<Course> courseCollectionOld = persistentUsers.getCourseCollection();
            Collection<Course> courseCollectionNew = users.getCourseCollection();
            Collection<Notifications> notificationsCollectionOld = persistentUsers.getNotificationsCollection();
            Collection<Notifications> notificationsCollectionNew = users.getNotificationsCollection();
            Collection<Groups> groupsCollectionOld = persistentUsers.getGroupsCollection();
            Collection<Groups> groupsCollectionNew = users.getGroupsCollection();
            Collection<Student> studentCollectionOld = persistentUsers.getStudentCollection();
            Collection<Student> studentCollectionNew = users.getStudentCollection();
            List<String> illegalOrphanMessages = null;
            for (Student studentCollectionOldStudent : studentCollectionOld) {
                if (!studentCollectionNew.contains(studentCollectionOldStudent)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Student " + studentCollectionOldStudent + " since its users field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (profileidProfileNew != null) {
                profileidProfileNew = em.getReference(profileidProfileNew.getClass(), profileidProfileNew.getIdProfile());
                users.setProfileidProfile(profileidProfileNew);
            }
            Collection<Activities> attachedActivitiesCollectionNew = new ArrayList<Activities>();
            for (Activities activitiesCollectionNewActivitiesToAttach : activitiesCollectionNew) {
                activitiesCollectionNewActivitiesToAttach = em.getReference(activitiesCollectionNewActivitiesToAttach.getClass(), activitiesCollectionNewActivitiesToAttach.getIdActivities());
                attachedActivitiesCollectionNew.add(activitiesCollectionNewActivitiesToAttach);
            }
            activitiesCollectionNew = attachedActivitiesCollectionNew;
            users.setActivitiesCollection(activitiesCollectionNew);
            Collection<Course> attachedCourseCollectionNew = new ArrayList<Course>();
            for (Course courseCollectionNewCourseToAttach : courseCollectionNew) {
                courseCollectionNewCourseToAttach = em.getReference(courseCollectionNewCourseToAttach.getClass(), courseCollectionNewCourseToAttach.getSyllabus());
                attachedCourseCollectionNew.add(courseCollectionNewCourseToAttach);
            }
            courseCollectionNew = attachedCourseCollectionNew;
            users.setCourseCollection(courseCollectionNew);
            Collection<Notifications> attachedNotificationsCollectionNew = new ArrayList<Notifications>();
            for (Notifications notificationsCollectionNewNotificationsToAttach : notificationsCollectionNew) {
                notificationsCollectionNewNotificationsToAttach = em.getReference(notificationsCollectionNewNotificationsToAttach.getClass(), notificationsCollectionNewNotificationsToAttach.getIdNotifications());
                attachedNotificationsCollectionNew.add(notificationsCollectionNewNotificationsToAttach);
            }
            notificationsCollectionNew = attachedNotificationsCollectionNew;
            users.setNotificationsCollection(notificationsCollectionNew);
            Collection<Groups> attachedGroupsCollectionNew = new ArrayList<Groups>();
            for (Groups groupsCollectionNewGroupsToAttach : groupsCollectionNew) {
                groupsCollectionNewGroupsToAttach = em.getReference(groupsCollectionNewGroupsToAttach.getClass(), groupsCollectionNewGroupsToAttach.getIdGroup());
                attachedGroupsCollectionNew.add(groupsCollectionNewGroupsToAttach);
            }
            groupsCollectionNew = attachedGroupsCollectionNew;
            users.setGroupsCollection(groupsCollectionNew);
            Collection<Student> attachedStudentCollectionNew = new ArrayList<Student>();
            for (Student studentCollectionNewStudentToAttach : studentCollectionNew) {
                studentCollectionNewStudentToAttach = em.getReference(studentCollectionNewStudentToAttach.getClass(), studentCollectionNewStudentToAttach.getStudentPK());
                attachedStudentCollectionNew.add(studentCollectionNewStudentToAttach);
            }
            studentCollectionNew = attachedStudentCollectionNew;
            users.setStudentCollection(studentCollectionNew);
            users = em.merge(users); //edita los valores en la base de datos
            if (profileidProfileOld != null && !profileidProfileOld.equals(profileidProfileNew)) {
                profileidProfileOld.getUsersCollection().remove(users);
                profileidProfileOld = em.merge(profileidProfileOld);
            }
            if (profileidProfileNew != null && !profileidProfileNew.equals(profileidProfileOld)) {
                profileidProfileNew.getUsersCollection().add(users);
                profileidProfileNew = em.merge(profileidProfileNew);
            }
            for (Activities activitiesCollectionOldActivities : activitiesCollectionOld) {
                if (!activitiesCollectionNew.contains(activitiesCollectionOldActivities)) {
                    activitiesCollectionOldActivities.getUsersCollection().remove(users);
                    activitiesCollectionOldActivities = em.merge(activitiesCollectionOldActivities);
                }
            }
            for (Activities activitiesCollectionNewActivities : activitiesCollectionNew) {
                if (!activitiesCollectionOld.contains(activitiesCollectionNewActivities)) {
                    activitiesCollectionNewActivities.getUsersCollection().add(users);
                    activitiesCollectionNewActivities = em.merge(activitiesCollectionNewActivities);
                }
            }
            for (Course courseCollectionOldCourse : courseCollectionOld) {
                if (!courseCollectionNew.contains(courseCollectionOldCourse)) {
                    courseCollectionOldCourse.getUsersCollection().remove(users);
                    courseCollectionOldCourse = em.merge(courseCollectionOldCourse);
                }
            }
            for (Course courseCollectionNewCourse : courseCollectionNew) {
                if (!courseCollectionOld.contains(courseCollectionNewCourse)) {
                    courseCollectionNewCourse.getUsersCollection().add(users);
                    courseCollectionNewCourse = em.merge(courseCollectionNewCourse);
                }
            }
            for (Notifications notificationsCollectionOldNotifications : notificationsCollectionOld) {
                if (!notificationsCollectionNew.contains(notificationsCollectionOldNotifications)) {
                    notificationsCollectionOldNotifications.getUsersCollection().remove(users);
                    notificationsCollectionOldNotifications = em.merge(notificationsCollectionOldNotifications);
                }
            }
            for (Notifications notificationsCollectionNewNotifications : notificationsCollectionNew) {
                if (!notificationsCollectionOld.contains(notificationsCollectionNewNotifications)) {
                    notificationsCollectionNewNotifications.getUsersCollection().add(users);
                    notificationsCollectionNewNotifications = em.merge(notificationsCollectionNewNotifications);
                }
            }
            for (Groups groupsCollectionOldGroups : groupsCollectionOld) {
                if (!groupsCollectionNew.contains(groupsCollectionOldGroups)) {
                    groupsCollectionOldGroups.getUsersCollection().remove(users);
                    groupsCollectionOldGroups = em.merge(groupsCollectionOldGroups);
                }
            }
            for (Groups groupsCollectionNewGroups : groupsCollectionNew) {
                if (!groupsCollectionOld.contains(groupsCollectionNewGroups)) {
                    groupsCollectionNewGroups.getUsersCollection().add(users);
                    groupsCollectionNewGroups = em.merge(groupsCollectionNewGroups);
                }
            }
            for (Student studentCollectionNewStudent : studentCollectionNew) {
                if (!studentCollectionOld.contains(studentCollectionNewStudent)) {
                    Users oldUsersOfStudentCollectionNewStudent = studentCollectionNewStudent.getUsers();
                    studentCollectionNewStudent.setUsers(users);
                    studentCollectionNewStudent = em.merge(studentCollectionNewStudent);
                    if (oldUsersOfStudentCollectionNewStudent != null && !oldUsersOfStudentCollectionNewStudent.equals(users)) {
                        oldUsersOfStudentCollectionNewStudent.getStudentCollection().remove(studentCollectionNewStudent);
                        oldUsersOfStudentCollectionNewStudent = em.merge(oldUsersOfStudentCollectionNewStudent);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = users.getIdUsers();
                if (findUsers(id) == null) {
                    throw new NonexistentEntityException("The users with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void editar(Users users) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();

            // Find the user by ID
            Users persistentUsers = em.find(Users.class, users.getIdUsers());

            // Update user fields
            persistentUsers.setName(users.getName());
            persistentUsers.setPassword(users.getPassword());
            persistentUsers.setUserName(users.getUserName());
            persistentUsers.setEmail(users.getEmail());
            persistentUsers.setPhoneNumber(users.getPhoneNumber());
            persistentUsers.setLastName(users.getLastName());

            // Merge the updated user object
            em.merge(persistentUsers);

            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = users.getIdUsers();
                if (findUsers(id) == null) {
                    throw new NonexistentEntityException("The users with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    //metodo eliminar
    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Users users;
            try {
                users = em.getReference(Users.class, id);
                users.getIdUsers();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The users with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Student> studentCollectionOrphanCheck = users.getStudentCollection();
//            for (Student studentCollectionOrphanCheckStudent : studentCollectionOrphanCheck) {
//                if (illegalOrphanMessages == null) {
//                    illegalOrphanMessages = new ArrayList<String>();
//                }
//                illegalOrphanMessages.add("This Users (" + users + ") cannot be destroyed since the Student " + studentCollectionOrphanCheckStudent + " in its studentCollection field has a non-nullable users field.");
//            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Profile profileidProfile = users.getProfileidProfile();
            if (profileidProfile != null) {
                profileidProfile.getUsersCollection().remove(users);
                profileidProfile = em.merge(profileidProfile);
            }
//            Collection<Activities> activitiesCollection = users.getActivitiesCollection();
//            for (Activities activitiesCollectionActivities : activitiesCollection) {
//                activitiesCollectionActivities.getUsersCollection().remove(users);
//                activitiesCollectionActivities = em.merge(activitiesCollectionActivities);
//            }
//            Collection<Course> courseCollection = users.getCourseCollection();
//            for (Course courseCollectionCourse : courseCollection) {
//                courseCollectionCourse.getUsersCollection().remove(users);
//                courseCollectionCourse = em.merge(courseCollectionCourse);
//            }
//            Collection<Notifications> notificationsCollection = users.getNotificationsCollection();
//            for (Notifications notificationsCollectionNotifications : notificationsCollection) {
//                notificationsCollectionNotifications.getUsersCollection().remove(users);
//                notificationsCollectionNotifications = em.merge(notificationsCollectionNotifications);
//            }
//            Collection<Groups> groupsCollection = users.getGroupsCollection();
//            for (Groups groupsCollectionGroups : groupsCollection) {
//                groupsCollectionGroups.getUsersCollection().remove(users);
//                groupsCollectionGroups = em.merge(groupsCollectionGroups);
//            }
            em.remove(users);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

//    public List<Users> findUsersEntities() {
//        return findUsersEntities(true, -1, -1);
//    }
//
//    public List<Users> findUsersEntities(int maxResults, int firstResult) {
//        return findUsersEntities(false, maxResults, firstResult);
//    }
    private ArrayList<Users> consultList() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Users.class));
            Query q = em.createQuery(cq);
//            if (!all) {
//                q.setMaxResults(maxResults);
//                q.setFirstResult(firstResult);
//            }
            return (ArrayList<Users>) q.getResultList();
        } finally {
            em.close();
        }
    }

    public Users findUsers(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Users.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsersCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Users> rt = cq.from(Users.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
