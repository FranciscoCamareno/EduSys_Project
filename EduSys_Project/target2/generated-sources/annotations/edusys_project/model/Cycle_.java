package edusys_project.model;

import edusys_project.model.Course;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-07-11T15:26:28", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Cycle.class)
public class Cycle_ { 

    public static volatile SingularAttribute<Cycle, Integer> idCycle;
    public static volatile SingularAttribute<Cycle, Date> finalDateClasses;
    public static volatile SingularAttribute<Cycle, Date> startDateEvaluations;
    public static volatile CollectionAttribute<Cycle, Course> courseCollection;
    public static volatile SingularAttribute<Cycle, Date> finalDateEvaluations;
    public static volatile SingularAttribute<Cycle, String> cycleName;
    public static volatile SingularAttribute<Cycle, Date> startDateClasses;

}