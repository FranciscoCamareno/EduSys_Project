/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edusys_project.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author fcama
 */
@Entity
@Table(name = "group")
@NamedQueries({
    @NamedQuery(name = "Groups.findAll", query = "SELECT g FROM Groups g"),
    @NamedQuery(name = "Groups.findByIdGroup", query = "SELECT g FROM Groups g WHERE g.idGroup = :idGroup"),
    @NamedQuery(name = "Groups.findByGroupNumber", query = "SELECT g FROM Groups g WHERE g.groupNumber = :groupNumber")})
public class Groups implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idGroup")
    private Integer idGroup;
    @Basic(optional = false)
    @Column(name = "group_number")
    private int groupNumber;
    @JoinTable(name = "users_has_group", joinColumns = {
        @JoinColumn(name = "Group_idGroup", referencedColumnName = "idGroup")}, inverseJoinColumns = {
        @JoinColumn(name = "Users_idUsers", referencedColumnName = "idUsers")})
    @ManyToMany
    private Collection<Users> usersCollection;
    @JoinColumn(name = "Course_syllabus", referencedColumnName = "syllabus")
    @ManyToOne(optional = false)
    private Course coursesyllabus;

    public Groups() {
    }

    public Groups(Integer idGroup) {
        this.idGroup = idGroup;
    }

    public Groups(Integer idGroup, int groupNumber) {
        this.idGroup = idGroup;
        this.groupNumber = groupNumber;
    }

    public Integer getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(Integer idGroup) {
        this.idGroup = idGroup;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    public Course getCoursesyllabus() {
        return coursesyllabus;
    }

    public void setCoursesyllabus(Course coursesyllabus) {
        this.coursesyllabus = coursesyllabus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGroup != null ? idGroup.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Groups)) {
            return false;
        }
        Groups other = (Groups) object;
        if ((this.idGroup == null && other.idGroup != null) || (this.idGroup != null && !this.idGroup.equals(other.idGroup))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edusys_project.model.Groups[ idGroup=" + idGroup + " ]";
    }
    
}
