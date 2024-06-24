/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edusys_project.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author fcama
 */
@Entity
@Table(name = "study_plan")
@NamedQueries({
    @NamedQuery(name = "StudyPlan.findAll", query = "SELECT s FROM StudyPlan s"),
    @NamedQuery(name = "StudyPlan.findByIdStudyPlan", query = "SELECT s FROM StudyPlan s WHERE s.idStudyPlan = :idStudyPlan"),
    @NamedQuery(name = "StudyPlan.findByAmountCredits", query = "SELECT s FROM StudyPlan s WHERE s.amountCredits = :amountCredits"),
    @NamedQuery(name = "StudyPlan.findByEffectiveDate", query = "SELECT s FROM StudyPlan s WHERE s.effectiveDate = :effectiveDate"),
    @NamedQuery(name = "StudyPlan.findByApprovalDate", query = "SELECT s FROM StudyPlan s WHERE s.approvalDate = :approvalDate")})
public class StudyPlan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idStudy_Plan")
    private Integer idStudyPlan;
    @Basic(optional = false)
    @Lob
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "amount_credits")
    private int amountCredits;
    @Column(name = "effective_date")
    @Temporal(TemporalType.DATE)
    private Date effectiveDate;
    @Column(name = "approval_date")
    @Temporal(TemporalType.DATE)
    private Date approvalDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studyPlanidStudyPlan")
    private Collection<Careers> careersCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studyPlanidStudyPlan")
    private Collection<Course> courseCollection;

    public StudyPlan() {
    }

    public StudyPlan(Integer idStudyPlan) {
        this.idStudyPlan = idStudyPlan;
    }

    public StudyPlan(Integer idStudyPlan, String description, int amountCredits) {
        this.idStudyPlan = idStudyPlan;
        this.description = description;
        this.amountCredits = amountCredits;
    }

    public Integer getIdStudyPlan() {
        return idStudyPlan;
    }

    public void setIdStudyPlan(Integer idStudyPlan) {
        this.idStudyPlan = idStudyPlan;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmountCredits() {
        return amountCredits;
    }

    public void setAmountCredits(int amountCredits) {
        this.amountCredits = amountCredits;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Date getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }

    public Collection<Careers> getCareersCollection() {
        return careersCollection;
    }

    public void setCareersCollection(Collection<Careers> careersCollection) {
        this.careersCollection = careersCollection;
    }

    public Collection<Course> getCourseCollection() {
        return courseCollection;
    }

    public void setCourseCollection(Collection<Course> courseCollection) {
        this.courseCollection = courseCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStudyPlan != null ? idStudyPlan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudyPlan)) {
            return false;
        }
        StudyPlan other = (StudyPlan) object;
        if ((this.idStudyPlan == null && other.idStudyPlan != null) || (this.idStudyPlan != null && !this.idStudyPlan.equals(other.idStudyPlan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edusys_project.model.StudyPlan[ idStudyPlan=" + idStudyPlan + " ]";
    }
    
}
