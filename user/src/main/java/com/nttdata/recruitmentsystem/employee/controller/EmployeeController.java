package com.nttdata.recruitmentsystem.employee.controller;

import com.nttdata.recruitmentsystem.employee.dto.Employee;
import com.nttdata.recruitmentsystem.employee.dto.EmployeeCreate;
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
    private EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping
    public List<Employee> getAll(){
        return employeeService.findAll();
    }
    @PostMapping
    public ResponseEntity<?> createEmployee(@RequestBody @Valid EmployeeCreate employee){
        employeeService.createEmployee(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/admins")
    public List<Employee> getAllAdmins(){
        return employeeService.findAllAdmins();
    }

}
