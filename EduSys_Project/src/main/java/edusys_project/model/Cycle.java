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
@Table(name = "cycle")
@NamedQueries({
    @NamedQuery(name = "Cycle.findAll", query = "SELECT c FROM Cycle c"),
    @NamedQuery(name = "Cycle.findByIdCycle", query = "SELECT c FROM Cycle c WHERE c.idCycle = :idCycle"),
    @NamedQuery(name = "Cycle.findByCycleName", query = "SELECT c FROM Cycle c WHERE c.cycleName = :cycleName"),
    @NamedQuery(name = "Cycle.findByStartDateClasses", query = "SELECT c FROM Cycle c WHERE c.startDateClasses = :startDateClasses"),
    @NamedQuery(name = "Cycle.findByFinalDateClasses", query = "SELECT c FROM Cycle c WHERE c.finalDateClasses = :finalDateClasses"),
    @NamedQuery(name = "Cycle.findByStartDateEvaluations", query = "SELECT c FROM Cycle c WHERE c.startDateEvaluations = :startDateEvaluations"),
    @NamedQuery(name = "Cycle.findByFinalDateEvaluations", query = "SELECT c FROM Cycle c WHERE c.finalDateEvaluations = :finalDateEvaluations")})
public class Cycle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idCycle")
    private Integer idCycle;
    @Basic(optional = false)
    @Column(name = "cycle_name")
    private String cycleName;
    @Column(name = "start_date_classes")
    @Temporal(TemporalType.DATE)
    private Date startDateClasses;
    @Column(name = "final_date_classes")
    @Temporal(TemporalType.DATE)
    private Date finalDateClasses;
    @Column(name = "start_date_evaluations")
    @Temporal(TemporalType.DATE)
    private Date startDateEvaluations;
    @Column(name = "final_date_evaluations")
    @Temporal(TemporalType.DATE)
    private Date finalDateEvaluations;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cycleidCycle")
    private Collection<Course> courseCollection;

    public Cycle() {
    }

    public Cycle(Integer idCycle) {
        this.idCycle = idCycle;
    }

    public Cycle(Integer idCycle, String cycleName) {
        this.idCycle = idCycle;
        this.cycleName = cycleName;
    }

    public Integer getIdCycle() {
        return idCycle;
    }

    public void setIdCycle(Integer idCycle) {
        this.idCycle = idCycle;
    }

    public String getCycleName() {
        return cycleName;
    }

    public void setCycleName(String cycleName) {
        this.cycleName = cycleName;
    }

    public Date getStartDateClasses() {
        return startDateClasses;
    }

    public void setStartDateClasses(Date startDateClasses) {
        this.startDateClasses = startDateClasses;
    }

    public Date getFinalDateClasses() {
        return finalDateClasses;
    }

    public void setFinalDateClasses(Date finalDateClasses) {
        this.finalDateClasses = finalDateClasses;
    }

    public Date getStartDateEvaluations() {
        return startDateEvaluations;
    }

    public void setStartDateEvaluations(Date startDateEvaluations) {
        this.startDateEvaluations = startDateEvaluations;
    }

    public Date getFinalDateEvaluations() {
        return finalDateEvaluations;
    }

    public void setFinalDateEvaluations(Date finalDateEvaluations) {
        this.finalDateEvaluations = finalDateEvaluations;
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
        hash += (idCycle != null ? idCycle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cycle)) {
            return false;
        }
        Cycle other = (Cycle) object;
        if ((this.idCycle == null && other.idCycle != null) || (this.idCycle != null && !this.idCycle.equals(other.idCycle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edusys_project.model.Cycle[ idCycle=" + idCycle + " ]";
    }
    
}
