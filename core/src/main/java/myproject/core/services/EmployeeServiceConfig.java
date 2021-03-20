package myproject.core.services;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;


@ObjectClassDefinition(name = "Employee service config")

public @interface EmployeeServiceConfig {

    @AttributeDefinition(
            name = "Name of Employee",
            type = AttributeType.STRING
    )
    String nameOfEmployee() default "John";

    @AttributeDefinition(
            name = "Id of Employee",
            type = AttributeType.INTEGER
    )
    int idOfEmployee() default 1;

}
