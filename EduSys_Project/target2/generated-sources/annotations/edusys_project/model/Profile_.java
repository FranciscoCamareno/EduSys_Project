package edusys_project.model;

import edusys_project.model.Modulo;
import edusys_project.model.Users;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-07-11T15:26:28", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Profile.class)
public class Profile_ { 

    public static volatile SingularAttribute<Profile, Integer> idProfile;
    public static volatile SingularAttribute<Profile, String> userType;
    public static volatile SingularAttribute<Profile, Modulo> moduleidModule;
    public static volatile CollectionAttribute<Profile, Users> usersCollection;

}