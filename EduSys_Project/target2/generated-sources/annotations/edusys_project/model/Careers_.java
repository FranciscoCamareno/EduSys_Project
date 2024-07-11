package edusys_project.model;

import edusys_project.model.StudyPlan;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-07-11T15:26:28", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Careers.class)
public class Careers_ { 

    public static volatile SingularAttribute<Careers, String> code;
    public static volatile SingularAttribute<Careers, String> workingMarket;
    public static volatile SingularAttribute<Careers, String> name;
    public static volatile SingularAttribute<Careers, String> description;
    public static volatile SingularAttribute<Careers, StudyPlan> studyPlanidStudyPlan;
    public static volatile SingularAttribute<Careers, String> profProfile;

}