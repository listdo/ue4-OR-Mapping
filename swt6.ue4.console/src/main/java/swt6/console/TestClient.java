package swt6.console;

import swt6.logic.*;
import swt6.domain.*;

import java.time.LocalDate;

public class TestClient {
    public static void main(String[] args)
    {
        EmployeeLogic employeeLogic = new EmployeeLogic();

        Employee empl = new Employee();
        empl.setFirstName("test");
        empl.setLastName("test");
        empl.setDateOfBirth(LocalDate.of(2020,1,1));

        System.out.println("Test");

        employeeLogic.createEmployee(empl);
    }
}
