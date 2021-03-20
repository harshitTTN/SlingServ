package myproject.core.services.impl;


import myproject.core.services.EmployeeService;
import myproject.core.services.EmployeeServiceConfig;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;

@Component(service = EmployeeService.class)
@Designate(ocd = EmployeeServiceConfig.class)
public class EmployeeServiceImpl implements EmployeeService {
    private String name;
    private int id;

    @Override
    public String Name(String name) {
        this.name = name;
        return name;
    }

    @Override
    public int id(int id) {
        this.id = id;
        return id;
    }
}
