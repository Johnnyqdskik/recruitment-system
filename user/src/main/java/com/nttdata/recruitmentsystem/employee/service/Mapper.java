package com.nttdata.recruitmentsystem.employee.service;

import com.nttdata.recruitmentsystem.employee.entity.EmployeeEntity;
import com.nttdata.recruitmentsystem.employee.dto.EmployeeCreate;
import com.nttdata.recruitmentsystem.employee.dto.Employee;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Mapper {
    public static Employee mapEntityToDto (EmployeeEntity employee){
        return Employee.builder()
                .id(employee.getId())
                .email(employee.getEmail())
                .role(employee.getRole())
                .active(employee.isActive())
                .build();
    }

    public static EmployeeEntity mapDtoToEntity(EmployeeCreate employee){
        return EmployeeEntity.builder()
                .email(employee.getEmail())
                .password(employee.getPassword())
                .role(employee.getRole())
                .active(true)
                .build();
    }
}
