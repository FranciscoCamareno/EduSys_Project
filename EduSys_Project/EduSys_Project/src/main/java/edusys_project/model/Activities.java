/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edusys_project.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "activities")
@NamedQueries({
    @NamedQuery(name = "Activities.findAll", query = "SELECT a FROM Activities a"),
    @NamedQuery(name = "Activities.findByIdActivities", query = "SELECT a FROM Activities a WHERE a.idActivities = :idActivities"),
    @NamedQuery(name = "Activities.findByDateTimeRecord", query = "SELECT a FROM Activities a WHERE a.dateTimeRecord = :dateTimeRecord"),
    @NamedQuery(name = "Activities.findByDateTimeExecution", query = "SELECT a FROM Activities a WHERE a.dateTimeExecution = :dateTimeExecution"),
    @NamedQuery(name = "Activities.findByTag", query = "SELECT a FROM Activities a WHERE a.tag = :tag"),
    @NamedQuery(name = "Activities.findByType", query = "SELECT a FROM Activities a WHERE a.type = :type"),
    @NamedQuery(name = "Activities.findByPercent", query = "SELECT a FROM Activities a WHERE a.percent = :percent"),
    @NamedQuery(name = "Activities.findByName", query = "SELECT a FROM Activities a WHERE a.name = :name"),
    @NamedQuery(name = "Activities.findByStatus", query = "SELECT a FROM Activities a WHERE a.status = :status"),
    @NamedQuery(name = "Activities.findByCategory", query = "SELECT a FROM Activities a WHERE a.category = :category"),
    @NamedQuery(name = "Activities.findByImage", query = "SELECT a FROM Activities a WHERE a.image = :image")})
public class Activities implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idActivities")
    private Integer idActivities;
    @Basic(optional = false)
    @Column(name = "date_time_record")
    @Temporal(TemporalType.DATE)
    private Date dateTimeRecord;
    @Basic(optional = false)
    @Column(name = "date_time_execution")
    @Temporal(TemporalType.DATE)
    private Date dateTimeExecution;
    @Column(name = "tag")
    private String tag;
    @Column(name = "type")
    private String type;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "percent")
    private BigDecimal percent;
    @Basic(optional = false)
    @Lob
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @Column(name = "category")
    private String category;
    @Column(name = "image")
    private String image;
    @JoinTable(name = "users_has_activities", joinColumns = {
        @JoinColumn(name = "Activities_idActivities", referencedColumnName = "idActivities")}, inverseJoinColumns = {
        @JoinColumn(name = "Users_idUsers", referencedColumnName = "idUsers")})
    @ManyToMany
    private Collection<Users> usersCollection;

    public Activities() {
    }

    public Activities(Integer idActivities) {
        this.idActivities = idActivities;
    }

    public Activities(Integer idActivities, Date dateTimeRecord, Date dateTimeExecution, String description, String name, String category) {
        this.idActivities = idActivities;
        this.dateTimeRecord = dateTimeRecord;
        this.dateTimeExecution = dateTimeExecution;
        this.description = description;
        this.name = name;
        this.category = category;
    }

    public Integer getIdActivities() {
        return idActivities;
    }

    public void setIdActivities(Integer idActivities) {
        this.idActivities = idActivities;
    }

    public Date getDateTimeRecord() {
        return dateTimeRecord;
    }

    public void setDateTimeRecord(Date dateTimeRecord) {
        this.dateTimeRecord = dateTimeRecord;
    }

    public Date getDateTimeExecution() {
        return dateTimeExecution;
    }

    public void setDateTimeExecution(Date dateTimeExecution) {
        this.dateTimeExecution = dateTimeExecution;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getPercent() {
        return percent;
    }

    public void setPercent(BigDecimal percent) {
        this.percent = percent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
        hash += (idActivities != null ? idActivities.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Activities)) {
            return false;
        }
        Activities other = (Activities) object;
        if ((this.idActivities == null && other.idActivities != null) || (this.idActivities != null && !this.idActivities.equals(other.idActivities))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edusys_project.model.Activities[ idActivities=" + idActivities + " ]";
    }
    
}
