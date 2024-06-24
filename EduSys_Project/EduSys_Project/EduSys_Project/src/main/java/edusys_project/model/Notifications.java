/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edusys_project.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author fcama
 */
@Entity
@Table(name = "notifications")
@NamedQueries({
    @NamedQuery(name = "Notifications.findAll", query = "SELECT n FROM Notifications n"),
    @NamedQuery(name = "Notifications.findByIdNotifications", query = "SELECT n FROM Notifications n WHERE n.idNotifications = :idNotifications"),
    @NamedQuery(name = "Notifications.findByType", query = "SELECT n FROM Notifications n WHERE n.type = :type"),
    @NamedQuery(name = "Notifications.findByDate", query = "SELECT n FROM Notifications n WHERE n.date = :date"),
    @NamedQuery(name = "Notifications.findByNotificationscol", query = "SELECT n FROM Notifications n WHERE n.notificationscol = :notificationscol")})
public class Notifications implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idNotifications")
    private Integer idNotifications;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @Lob
    @Column(name = "send_message")
    private String sendMessage;
    @Basic(optional = false)
    @Column(name = "Notificationscol")
    private String notificationscol;
    @JoinTable(name = "users_has_notifications", joinColumns = {
        @JoinColumn(name = "Notifications_idNotifications", referencedColumnName = "idNotifications")}, inverseJoinColumns = {
        @JoinColumn(name = "Users_idUsers", referencedColumnName = "idUsers")})
    @ManyToMany
    private Collection<Users> usersCollection;

    public Notifications() {
    }

    public Notifications(Integer idNotifications) {
        this.idNotifications = idNotifications;
    }

    public Notifications(Integer idNotifications, String type, Date date, String sendMessage, String notificationscol) {
        this.idNotifications = idNotifications;
        this.type = type;
        this.date = date;
        this.sendMessage = sendMessage;
        this.notificationscol = notificationscol;
    }

    public Integer getIdNotifications() {
        return idNotifications;
    }

    public void setIdNotifications(Integer idNotifications) {
        this.idNotifications = idNotifications;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSendMessage() {
        return sendMessage;
    }

    public void setSendMessage(String sendMessage) {
        this.sendMessage = sendMessage;
    }

    public String getNotificationscol() {
        return notificationscol;
    }

    public void setNotificationscol(String notificationscol) {
        this.notificationscol = notificationscol;
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
        hash += (idNotifications != null ? idNotifications.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notifications)) {
            return false;
        }
        Notifications other = (Notifications) object;
        if ((this.idNotifications == null && other.idNotifications != null) || (this.idNotifications != null && !this.idNotifications.equals(other.idNotifications))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edusys_project.model.Notifications[ idNotifications=" + idNotifications + " ]";
    }
    
}
