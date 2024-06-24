/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edusys_project.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author fcama
 */
@Entity
@Table(name = "profile")
//@NamedQueries({
//    @NamedQuery(name = "Profile.findAll", query = "SELECT p FROM Profile p"),
//    @NamedQuery(name = "Profile.findByIdProfile", query = "SELECT p FROM Profile p WHERE p.idProfile = :idProfile"),
//    @NamedQuery(name = "Profile.findByUserType", query = "SELECT p FROM Profile p WHERE p.userType = :userType")})
public class Profile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idProfile")
    private Integer idProfile;
    @Basic(optional = false)
    @Column(name = "user_type")
    private String userType;
    @JoinColumn(name = "Module_idModule", referencedColumnName = "idModule")
    @ManyToOne(optional = false)
    private Modulo moduleidModule;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profileidProfile")
    private Collection<Users> usersCollection;

    public Profile() {
    }

    public Profile(Integer idProfile) {
        this.idProfile = idProfile;
    }

    public Profile(Integer idProfile, String userType) {
        this.idProfile = idProfile;
        this.userType = userType;
    }

    public Profile(Integer idProfile, String userType, Modulo moduleidModule) {
        this.idProfile = idProfile;
        this.userType = userType;
        this.moduleidModule = moduleidModule;
    }
    
    
    
    public Integer getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(Integer idProfile) {
        this.idProfile = idProfile;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Modulo getModuleidModule() {
        return moduleidModule;
    }

    public void setModuleidModule(Modulo moduleidModule) {
        this.moduleidModule = moduleidModule;
    }

    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProfile != null ? idProfile.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profile)) {
            return false;
        }
        Profile other = (Profile) object;
        if ((this.idProfile == null && other.idProfile != null) || (this.idProfile != null && !this.idProfile.equals(other.idProfile))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edusys_project.model.Profile[ idProfile=" + idProfile + " ]";
    }
    
}
