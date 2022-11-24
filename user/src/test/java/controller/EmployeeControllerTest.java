package controller;

import com.nttdata.recruitmentsystem.employee.controller.EmployeeController;
import com.nttdata.recruitmentsystem.employee.dto.Employee;
import com.nttdata.recruitmentsystem.employee.dto.EmployeeRole;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {

    @Mock
    private EmployeeController employeeController;

    @Test
    public void testGetAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        Employee e = new Employee (1, "n@gmail.com",  true, EmployeeRole.RECRUITER );
        employees.add(e);

        Mockito.when(employeeController.findAllByRole(EmployeeRole.RECRUITER)).thenReturn(employees);
        List<Employee> finalList = employeeController.findAllByRole(EmployeeRole.RECRUITER);

        if(!finalList.isEmpty()) {
            assertNotNull(e);
            assertEquals(e.getId(), finalList.get(0).getId());
            assertEquals(e.getEmail(), finalList.get(0).getEmail());
            assertEquals(e.getRole(), finalList.get(0).getRole());
        }
        System.out.println(employees);
    }

}
