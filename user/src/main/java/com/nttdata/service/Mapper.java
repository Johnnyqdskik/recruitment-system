package com.nttdata.service;

import com.nttdata.dto.Employee;
import com.nttdata.entity.EmployeeEntity;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Mapper {
    public static Employee mapEntityToDto (EmployeeEntity employee){
        return Employee.builder()
                .email(employee.getEmail())
                .password(employee.getPassword())
                .role(employee.getRole())
                .active(employee.isActive())
                .build();
    }

    public static EmployeeEntity mapDtoToEntity(Employee employee){
        return EmployeeEntity.builder()
                .email(employee.getEmail())
                .password(employee.getPassword())
                .role(employee.getRole())
                .active(employee.isActive())
                .build();
    }
}
