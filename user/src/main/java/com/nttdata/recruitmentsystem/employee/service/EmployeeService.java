package com.nttdata.recruitmentsystem.employee.service;

import com.nttdata.recruitmentsystem.employee.dto.Employee;
import com.nttdata.recruitmentsystem.employee.dto.EmployeeCreate;
import com.nttdata.recruitmentsystem.employee.dto.EmployeeRole;
import com.nttdata.recruitmentsystem.employee.entity.EmployeeEntity;
import com.nttdata.recruitmentsystem.employee.repository.EmployeeRepository;
import com.nttdata.recruitmentsystem.exceptionHandler.userExceptions.UsernameDuplicateException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository,  PasswordEncoder passwordEncoder) {
        this.employeeRepository = employeeRepository;
        this.passwordEncoder = passwordEncoder;
    }
    private PasswordEncoder passwordEncoder;

    public List<Employee> findAll(){
        Iterable<EmployeeEntity> employeeEntities = employeeRepository.findAll();

        List<Employee> employees= StreamSupport.stream(employeeEntities.spliterator(), false)
                .map(EmployeeMapper::mapEntityToDto)
                .collect(Collectors.toList());
        return employees;
    }

    public List<Employee> findAllByRole(EmployeeRole role){
        Iterable<EmployeeEntity> employeeEntities = employeeRepository.findAllByRole(role);

        List<Employee> result = StreamSupport.stream(employeeEntities.spliterator(), false)
                .map(EmployeeMapper::mapEntityToDto)
                .collect(Collectors.toList());
        return result;
    }
    public void createEmployee(EmployeeCreate employee) throws UsernameDuplicateException {
        Optional<EmployeeEntity> existingEmployee = employeeRepository.findByEmail(employee.getEmail());
        if(!existingEmployee.isEmpty()){
            throw new UsernameDuplicateException(employee.getEmail());
        }
        EmployeeEntity entity = EmployeeMapper.mapDtoToEntity(employee);
        entity.setPassword(passwordEncoder.encode(employee.getPassword()));

        employeeRepository.save(entity);
    }


}
