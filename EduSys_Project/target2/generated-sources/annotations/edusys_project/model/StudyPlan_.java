package edusys_project.model;

import edusys_project.model.Careers;
import edusys_project.model.Course;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-07-11T15:26:28", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(StudyPlan.class)
public class StudyPlan_ { 

    public static volatile SingularAttribute<StudyPlan, Date> approvalDate;
    public static volatile SingularAttribute<StudyPlan, Integer> idStudyPlan;
    public static volatile CollectionAttribute<StudyPlan, Course> courseCollection;
    public static volatile SingularAttribute<StudyPlan, String> description;
    public static volatile SingularAttribute<StudyPlan, Integer> amountCredits;
    public static volatile SingularAttribute<StudyPlan, Date> effectiveDate;
    public static volatile CollectionAttribute<StudyPlan, Careers> careersCollection;

}