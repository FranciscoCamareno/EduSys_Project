/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edusys_project.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author fcama
 */
@Embeddable
public class StudentPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "carnet")
    private String carnet;
    @Basic(optional = false)
    @Column(name = "Users_idUsers")
    private int usersidUsers;

    public StudentPK() {
    }

    public StudentPK(String carnet, int usersidUsers) {
        this.carnet = carnet;
        this.usersidUsers = usersidUsers;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public int getUsersidUsers() {
        return usersidUsers;
    }

    public void setUsersidUsers(int usersidUsers) {
        this.usersidUsers = usersidUsers;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (carnet != null ? carnet.hashCode() : 0);
        hash += (int) usersidUsers;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentPK)) {
            return false;
        }
        StudentPK other = (StudentPK) object;
        if ((this.carnet == null && other.carnet != null) || (this.carnet != null && !this.carnet.equals(other.carnet))) {
            return false;
        }
        if (this.usersidUsers != other.usersidUsers) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edusys_project.model.StudentPK[ carnet=" + carnet + ", usersidUsers=" + usersidUsers + " ]";
    }
    
}
