package edusys_project.model;

import edusys_project.model.Course;
import edusys_project.model.Users;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-07-11T15:26:28", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Groups.class)
public class Groups_ { 

    public static volatile SingularAttribute<Groups, Integer> idGroup;
    public static volatile CollectionAttribute<Groups, Users> usersCollection;
    public static volatile SingularAttribute<Groups, Integer> groupNumber;
    public static volatile SingularAttribute<Groups, Course> coursesyllabus;

}