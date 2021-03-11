package swt6.logic;

import swt6.domain.*;
import swt6.repository.impl.EmployeeDao;
import swt6.repository.interfaces.EmployeeService;

public class EmployeeLogic {

    public void createEmployee(Employee empl)
    {
        EmployeeService employeeService = new EmployeeDao();
        employeeService.create(empl);
    }
}
