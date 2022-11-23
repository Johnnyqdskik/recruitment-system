package com.nttdata.recruitmentsystem.employee.controller;

import com.nttdata.recruitmentsystem.employee.service.EmployeeService;
import com.nttdata.recruitmentsystem.employee.dto.Employee;
import com.nttdata.recruitmentsystem.employee.dto.EmployeeCreate;
import com.nttdata.recruitmentsystem.employee.dto.EmployeeRole;
import com.nttdata.recruitmentsystem.employee.service.EmployeeService;
import com.nttdata.recruitmentsystem.exceptionHandler.userExceptions.EmailNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @PostMapping
    public ResponseEntity<?> createEmployee(@RequestBody @Valid EmployeeCreate employee) throws EmailNotFoundException {
          employeeService.createEmployee(employee);
          return ResponseEntity.ok().build();
    }
    @GetMapping
    @PreAuthorize("hasAuthority('RECRUITER')")
    public List<Employee> findAllByRole (@RequestParam(name = "role", required = false)EmployeeRole role) {
        if (role == null) {
            return employeeService.findAll();
        } else {
            return employeeService.findAllByRole(role);
        }

    }
}
