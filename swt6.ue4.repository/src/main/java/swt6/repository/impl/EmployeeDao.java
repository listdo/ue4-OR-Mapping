package swt6.repository.impl;

import swt6.domain.*;
import swt6.repository.interfaces.EmployeeService;
import swt6.repository.util.EntityManager;

import java.util.Set;

public class EmployeeDao implements EmployeeService {
    @Override
    public Employee create(Employee empl) {
        return EntityManager.saveEntity(empl);
    }

    @Override
    public Set<Employee> readAll() {
        return null;
    }

    @Override
    public Set<Employee> readById() {
        return null;
    }

    @Override
    public Employee update(Employee empl) {

        return EntityManager.updateEntity(empl.getId(), empl, Employee.class);
    }

    @Override
    public boolean delete(Employee empl) {
        return false;
    }
}
