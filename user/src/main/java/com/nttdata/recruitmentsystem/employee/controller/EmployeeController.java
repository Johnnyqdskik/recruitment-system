package com.nttdata.recruitmentsystem.employee.controller;

import com.nttdata.recruitmentsystem.employee.dto.Employee;
import com.nttdata.recruitmentsystem.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {
    private EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping
    public List<Employee> getAll(){
        return employeeService.findAll();
    }
    public ResponseEntity<?> createEmployee(@RequestBody @Valid Employee employee){
        employeeService.createEmployee(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/admins")
    public List<Employee> getAllAdmins(){
        return employeeService.findAllAdmins();
    }

}
