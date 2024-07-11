package edusys_project.model;

import edusys_project.model.Cycle;
import edusys_project.model.Groups;
import edusys_project.model.StudyPlan;
import edusys_project.model.Users;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-07-11T15:26:28", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Course.class)
public class Course_ { 

    public static volatile SingularAttribute<Course, String> syllabus;
    public static volatile SingularAttribute<Course, String> modality;
    public static volatile SingularAttribute<Course, Integer> indepWorkHour;
    public static volatile SingularAttribute<Course, Cycle> cycleidCycle;
    public static volatile SingularAttribute<Course, String> name;
    public static volatile SingularAttribute<Course, String> description;
    public static volatile SingularAttribute<Course, Integer> amountCredits;
    public static volatile SingularAttribute<Course, Integer> lessonHours;
    public static volatile SingularAttribute<Course, StudyPlan> studyPlanidStudyPlan;
    public static volatile CollectionAttribute<Course, Users> usersCollection;
    public static volatile CollectionAttribute<Course, Groups> groupsCollection;

}