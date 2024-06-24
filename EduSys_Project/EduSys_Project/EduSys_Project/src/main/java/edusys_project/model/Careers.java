/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edusys_project.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author fcama
 */
@Entity
@Table(name = "careers")
@NamedQueries({
    @NamedQuery(name = "Careers.findAll", query = "SELECT c FROM Careers c"),
    @NamedQuery(name = "Careers.findByCode", query = "SELECT c FROM Careers c WHERE c.code = :code"),
    @NamedQuery(name = "Careers.findByName", query = "SELECT c FROM Careers c WHERE c.name = :name")})
public class Careers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @Lob
    @Column(name = "prof_profile")
    private String profProfile;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Lob
    @Column(name = "working_market")
    private String workingMarket;
    @Basic(optional = false)
    @Lob
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "Study_Plan_idStudy_Plan", referencedColumnName = "idStudy_Plan")
    @ManyToOne(optional = false)
    private StudyPlan studyPlanidStudyPlan;

    public Careers() {
    }

    public Careers(String code) {
        this.code = code;
    }

    public Careers(String code, String profProfile, String name, String workingMarket, String description) {
        this.code = code;
        this.profProfile = profProfile;
        this.name = name;
        this.workingMarket = workingMarket;
        this.description = description;
    }

    public Careers(String code, String profProfile, String name, String workingMarket, String description, StudyPlan studyPlanidStudyPlan) {
        this.code = code;
        this.profProfile = profProfile;
        this.name = name;
        this.workingMarket = workingMarket;
        this.description = description;
        this.studyPlanidStudyPlan = studyPlanidStudyPlan;
    }
    
    

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getProfProfile() {
        return profProfile;
    }

    public void setProfProfile(String profProfile) {
        this.profProfile = profProfile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorkingMarket() {
        return workingMarket;
    }

    public void setWorkingMarket(String workingMarket) {
        this.workingMarket = workingMarket;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StudyPlan getStudyPlanidStudyPlan() {
        return studyPlanidStudyPlan;
    }

    public void setStudyPlanidStudyPlan(StudyPlan studyPlanidStudyPlan) {
        this.studyPlanidStudyPlan = studyPlanidStudyPlan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Careers)) {
            return false;
        }
        Careers other = (Careers) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edusys_project.model.Careers[ code=" + code + " ]";
    }
    
}
