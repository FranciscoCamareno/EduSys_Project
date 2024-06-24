/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edusys_project.model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author fcama
 */
@Entity
@Table(name = "student")
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findByCarnet", query = "SELECT s FROM Student s WHERE s.studentPK.carnet = :carnet"),
    @NamedQuery(name = "Student.findByUsersidUsers", query = "SELECT s FROM Student s WHERE s.studentPK.usersidUsers = :usersidUsers")})
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StudentPK studentPK;
    @JoinColumn(name = "Users_idUsers", referencedColumnName = "idUsers", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Users users;

    public Student() {
    }

    public Student(StudentPK studentPK) {
        this.studentPK = studentPK;
    }

    public Student(String carnet, int usersidUsers) {
        this.studentPK = new StudentPK(carnet, usersidUsers);
    }

    public StudentPK getStudentPK() {
        return studentPK;
    }

    public void setStudentPK(StudentPK studentPK) {
        this.studentPK = studentPK;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentPK != null ? studentPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.studentPK == null && other.studentPK != null) || (this.studentPK != null && !this.studentPK.equals(other.studentPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edusys_project.model.Student[ studentPK=" + studentPK + " ]";
    }
    
}
