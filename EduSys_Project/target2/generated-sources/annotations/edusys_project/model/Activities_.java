package edusys_project.model;

import edusys_project.model.Users;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-07-11T15:26:28", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Activities.class)
public class Activities_ { 

    public static volatile SingularAttribute<Activities, Date> dateTimeRecord;
    public static volatile SingularAttribute<Activities, String> image;
    public static volatile SingularAttribute<Activities, Date> dateTimeExecution;
    public static volatile SingularAttribute<Activities, Integer> idActivities;
    public static volatile SingularAttribute<Activities, String> name;
    public static volatile SingularAttribute<Activities, String> description;
    public static volatile SingularAttribute<Activities, String> tag;
    public static volatile SingularAttribute<Activities, String> type;
    public static volatile SingularAttribute<Activities, String> category;
    public static volatile CollectionAttribute<Activities, Users> usersCollection;
    public static volatile SingularAttribute<Activities, BigDecimal> percent;
    public static volatile SingularAttribute<Activities, String> status;

}