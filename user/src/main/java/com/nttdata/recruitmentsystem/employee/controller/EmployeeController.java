package com.nttdata.recruitmentsystem.employee.controller;

import com.nttdata.recruitmentsystem.employee.dto.Employee;
import com.nttdata.recruitmentsystem.employee.dto.EmployeeCreate;
import com.nttdata.recruitmentsystem.employee.dto.EmployeeRole;
import com.nttdata.recruitmentsystem.employee.entity.EmployeeEntity;
import com.nttdata.recruitmentsystem.employee.exceptionHandler.WebException;
import com.nttdata.recruitmentsystem.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> createEmployee(@RequestBody @Valid EmployeeCreate employee){
        try {
            employeeService.createEmployee(employee);
            return ResponseEntity.ok().build();
        } catch (WebException.EmailExistsException e) {
            return ResponseEntity.badRequest().body(e.getMessageDto());
        }
    }
    @GetMapping
    public List<Employee> findAllByRole (@RequestParam(name = "role", required = false)EmployeeRole role) {
        if (role == null) {
            return employeeService.findAll();
        } else {
            return employeeService.findAllByRole(role);
        }

    }
}
