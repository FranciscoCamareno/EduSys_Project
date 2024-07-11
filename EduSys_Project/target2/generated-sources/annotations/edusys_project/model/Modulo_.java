package edusys_project.model;

import edusys_project.model.Profile;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-07-11T15:26:28", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Modulo.class)
public class Modulo_ { 

    public static volatile SingularAttribute<Modulo, String> name;
    public static volatile SingularAttribute<Modulo, String> description;
    public static volatile SingularAttribute<Modulo, Integer> idModule;
    public static volatile CollectionAttribute<Modulo, Profile> profileCollection;

}