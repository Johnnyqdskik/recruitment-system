package com.nttdata.UserDetails;

import com.nttdata.UserDetails.UserDetailsImpl;
import com.nttdata.entity.EmployeeEntity;
import com.nttdata.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

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
