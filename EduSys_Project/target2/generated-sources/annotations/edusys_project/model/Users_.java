package edusys_project.model;

import edusys_project.model.Activities;
import edusys_project.model.Course;
import edusys_project.model.Groups;
import edusys_project.model.Notifications;
import edusys_project.model.Profile;
import edusys_project.model.Student;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-07-11T15:26:28", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, Profile> profileidProfile;
    public static volatile SingularAttribute<Users, String> lastName;
    public static volatile CollectionAttribute<Users, Activities> activitiesCollection;
    public static volatile CollectionAttribute<Users, Course> courseCollection;
    public static volatile SingularAttribute<Users, String> userName;
    public static volatile CollectionAttribute<Users, Notifications> notificationsCollection;
    public static volatile SingularAttribute<Users, String> password;
    public static volatile SingularAttribute<Users, String> phoneNumber;
    public static volatile SingularAttribute<Users, String> name;
    public static volatile CollectionAttribute<Users, Student> studentCollection;
    public static volatile SingularAttribute<Users, Integer> idUsers;
    public static volatile CollectionAttribute<Users, Groups> groupsCollection;
    public static volatile SingularAttribute<Users, String> email;

}