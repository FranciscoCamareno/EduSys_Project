/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edusys_project.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
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
@Table(name = "course")
@NamedQueries({
    @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c"),
    @NamedQuery(name = "Course.findBySyllabus", query = "SELECT c FROM Course c WHERE c.syllabus = :syllabus"),
    @NamedQuery(name = "Course.findByName", query = "SELECT c FROM Course c WHERE c.name = :name"),
    @NamedQuery(name = "Course.findByAmountCredits", query = "SELECT c FROM Course c WHERE c.amountCredits = :amountCredits"),
    @NamedQuery(name = "Course.findByModality", query = "SELECT c FROM Course c WHERE c.modality = :modality"),
    @NamedQuery(name = "Course.findByLessonHours", query = "SELECT c FROM Course c WHERE c.lessonHours = :lessonHours"),
    @NamedQuery(name = "Course.findByIndepWorkHour", query = "SELECT c FROM Course c WHERE c.indepWorkHour = :indepWorkHour")})
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "syllabus")
    private String syllabus;
    @Basic(optional = false)
    @Lob
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "amount_credits")
    private int amountCredits;
    @Basic(optional = false)
    @Column(name = "modality")
    private String modality;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "lesson_hours")
    private int lessonHours;
    @Basic(optional = false)
    @Column(name = "indep_work_hour")
    private int indepWorkHour;
    @JoinTable(name = "users_has_course", joinColumns = {
        @JoinColumn(name = "Course_syllabus", referencedColumnName = "syllabus")}, inverseJoinColumns = {
        @JoinColumn(name = "Users_idUsers", referencedColumnName = "idUsers")})
    @ManyToMany
    private Collection<Users> usersCollection;
    @JoinColumn(name = "Cycle_idCycle", referencedColumnName = "idCycle")
    @ManyToOne(optional = false)
    private Cycle cycleidCycle;
    @JoinColumn(name = "Study_Plan_idStudy_Plan", referencedColumnName = "idStudy_Plan")
    @ManyToOne(optional = false)
    private StudyPlan studyPlanidStudyPlan;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coursesyllabus")
    private Collection<Groups> groupsCollection;

    public Course() {
    }

    public Course(String syllabus) {
        this.syllabus = syllabus;
    }
    
    public Course(String name, int amountCredits, String description, int indepWorkHour, int lessonHours, String modality) {
        this.name = name;
        this.amountCredits = amountCredits;
        this.description = description;
        this.indepWorkHour = indepWorkHour;
        this.lessonHours = lessonHours;
        this.modality = modality;
    }

    public Course(String syllabus, String description, String name, int amountCredits, String modality, int lessonHours, int indepWorkHour) {
        this.syllabus = syllabus;
        this.description = description;
        this.name = name;
        this.amountCredits = amountCredits;
        this.modality = modality;
        this.lessonHours = lessonHours;
        this.indepWorkHour = indepWorkHour;
    }

    public String getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(String syllabus) {
        this.syllabus = syllabus;
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

    public int getAmountCredits() {
        return amountCredits;
    }

    public void setAmountCredits(int amountCredits) {
        this.amountCredits = amountCredits;
    }

    public String getModality() {
        return modality;
    }

    public void setModality(String modality) {
        this.modality = modality;
    }

    public int getLessonHours() {
        return lessonHours;
    }

    public void setLessonHours(int lessonHours) {
        this.lessonHours = lessonHours;
    }

    public int getIndepWorkHour() {
        return indepWorkHour;
    }

    public void setIndepWorkHour(int indepWorkHour) {
        this.indepWorkHour = indepWorkHour;
    }

    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    public Cycle getCycleidCycle() {
        return cycleidCycle;
    }

    public void setCycleidCycle(Cycle cycleidCycle) {
        this.cycleidCycle = cycleidCycle;
    }

    public StudyPlan getStudyPlanidStudyPlan() {
        return studyPlanidStudyPlan;
    }

    public void setStudyPlanidStudyPlan(StudyPlan studyPlanidStudyPlan) {
        this.studyPlanidStudyPlan = studyPlanidStudyPlan;
    }

    public Collection<Groups> getGroupsCollection() {
        return groupsCollection;
    }

    public void setGroupsCollection(Collection<Groups> groupsCollection) {
        this.groupsCollection = groupsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (syllabus != null ? syllabus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.syllabus == null && other.syllabus != null) || (this.syllabus != null && !this.syllabus.equals(other.syllabus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edusys_project.model.Course[ syllabus=" + syllabus + " ]";
    }
    
}
