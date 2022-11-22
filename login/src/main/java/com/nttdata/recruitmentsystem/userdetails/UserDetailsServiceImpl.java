package com.nttdata.recruitmentsystem.userdetails;

import com.nttdata.recruitmentsystem.employee.entity.EmployeeEntity;
import com.nttdata.recruitmentsystem.employee.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private final EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<EmployeeEntity> employee = employeeRepository.findByEmail(email);

        if(!employee.isPresent()){
            throw new UsernameNotFoundException("User with provided email does not exist!");
        }

        UserDetailsImpl user = UserDetailsImpl.builder()
                .email(employee.get().getEmail())
                .password(employee.get().getPassword())
                .isActive(employee.get().isActive())
                .role(employee.get().getRole().name())
                .build();

        return user;
    }
}
