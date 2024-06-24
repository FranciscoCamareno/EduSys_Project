/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edusys_project.controller.JPA;

import edusys_project.controller.JPA.exceptions.NonexistentEntityException;
import edusys_project.controller.JPA.exceptions.PreexistingEntityException;
import edusys_project.model.Student;
import edusys_project.model.StudentPK;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import edusys_project.model.Users;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author fcama
 */
public class StudentJpaController implements Serializable {

    public StudentJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Student student) throws PreexistingEntityException, Exception {
        if (student.getStudentPK() == null) {
            student.setStudentPK(new StudentPK());
        }
        student.getStudentPK().setUsersidUsers(student.getUsers().getIdUsers());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Users users = student.getUsers();
            if (users != null) {
                users = em.getReference(users.getClass(), users.getIdUsers());
                student.setUsers(users);
            }
            em.persist(student);
            if (users != null) {
                users.getStudentCollection().add(student);
                users = em.merge(users);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findStudent(student.getStudentPK()) != null) {
                throw new PreexistingEntityException("Student " + student + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Student student) throws NonexistentEntityException, Exception {
        student.getStudentPK().setUsersidUsers(student.getUsers().getIdUsers());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Student persistentStudent = em.find(Student.class, student.getStudentPK());
            Users usersOld = persistentStudent.getUsers();
            Users usersNew = student.getUsers();
            if (usersNew != null) {
                usersNew = em.getReference(usersNew.getClass(), usersNew.getIdUsers());
                student.setUsers(usersNew);
            }
            student = em.merge(student);
            if (usersOld != null && !usersOld.equals(usersNew)) {
                usersOld.getStudentCollection().remove(student);
                usersOld = em.merge(usersOld);
            }
            if (usersNew != null && !usersNew.equals(usersOld)) {
                usersNew.getStudentCollection().add(student);
                usersNew = em.merge(usersNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                StudentPK id = student.getStudentPK();
                if (findStudent(id) == null) {
                    throw new NonexistentEntityException("The student with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(StudentPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Student student;
            try {
                student = em.getReference(Student.class, id);
                student.getStudentPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The student with id " + id + " no longer exists.", enfe);
            }
            Users users = student.getUsers();
            if (users != null) {
                users.getStudentCollection().remove(student);
                users = em.merge(users);
            }
            em.remove(student);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Student> findStudentEntities() {
        return findStudentEntities(true, -1, -1);
    }

    public List<Student> findStudentEntities(int maxResults, int firstResult) {
        return findStudentEntities(false, maxResults, firstResult);
    }

    private List<Student> findStudentEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Student.class));
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

    public Student findStudent(StudentPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Student.class, id);
        } finally {
            em.close();
        }
    }

    public int getStudentCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Student> rt = cq.from(Student.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
