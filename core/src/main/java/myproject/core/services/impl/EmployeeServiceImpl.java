package myproject.core.services.impl;


import myproject.core.services.EmployeeService;
import org.osgi.service.component.annotations.Component;

@Component(service = EmployeeService.class)
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
