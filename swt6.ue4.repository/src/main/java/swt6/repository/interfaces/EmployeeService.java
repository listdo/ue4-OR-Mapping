package swt6.repository.interfaces;

import swt6.domain.*;
import java.util.Set;

public interface EmployeeService {
    Employee create(Employee empl);
    Set<Employee> readAll();
    Set<Employee> readById();
    Employee update(Employee empl);
    boolean delete(Employee empl);
}
