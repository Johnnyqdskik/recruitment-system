package com.nttdata.recruitmentsystem.employee.service;

import com.nttdata.recruitmentsystem.employee.dto.Employee;
import com.nttdata.recruitmentsystem.employee.entity.EmployeeEntity;
import com.nttdata.recruitmentsystem.employee.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    //controller
//    @Bean
//    public PasswordEncoder encoder() {
//        return new BCryptPasswordEncoder();
//    }
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//    @Autowired
//    private UserDetailsService userDetailsService;

//    @Bean
//    public DaoAuthenticationProvider authProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userDetailsService);
//        authProvider.setPasswordEncoder(encoder());
//        return authProvider;
//    }

    public List<Employee> findAll(){
        Iterable<EmployeeEntity> employeeEntities = employeeRepository.findAll();

        List<Employee> employees= StreamSupport.stream(employeeEntities.spliterator(), false)
                .map(Mapper::mapEntityToDto)
                .collect(Collectors.toList());
        return employees;
    }

    public List<Employee> findAllAdmins(){
        Iterable<EmployeeEntity> employeeEntities = employeeRepository.findAllAdmins();

        List<Employee> result = StreamSupport.stream(employeeEntities.spliterator(), false)
                .map(Mapper::mapEntityToDto)
                .collect(Collectors.toList());
        return result;
    }
    public void createEmployee(Employee employee) {
        Optional<EmployeeEntity> existingPerson = employeeRepository.findByEmail(employee.getEmail());
        if (existingPerson.isPresent()) {
            throw new IllegalArgumentException("Employee with that email" + employee.getEmail() + "already exists");
        }
        Employee newEmployee = new Employee();
        newEmployee.setEmail(employee.getEmail());
        newEmployee.setPassword(employee.getPassword()); //TODO: PASSWORD HASH
        newEmployee.setRole(employee.getRole());
        employeeRepository.save(Mapper.mapDtoToEntity(newEmployee));
    }
}
