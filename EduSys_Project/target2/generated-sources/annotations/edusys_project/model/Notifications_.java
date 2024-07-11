package edusys_project.model;

import edusys_project.model.Users;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-07-11T15:26:28", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Notifications.class)
public class Notifications_ { 

    public static volatile SingularAttribute<Notifications, Date> date;
    public static volatile SingularAttribute<Notifications, String> notificationscol;
    public static volatile SingularAttribute<Notifications, String> sendMessage;
    public static volatile SingularAttribute<Notifications, Integer> idNotifications;
    public static volatile SingularAttribute<Notifications, String> type;
    public static volatile CollectionAttribute<Notifications, Users> usersCollection;

}