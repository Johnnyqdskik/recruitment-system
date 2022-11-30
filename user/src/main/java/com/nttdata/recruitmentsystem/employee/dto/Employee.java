package com.nttdata.recruitmentsystem.employee.dto;

import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    private int id;
    private String email;
    @Builder.Default
    private boolean active = true;
    @Enumerated(EnumType.STRING)
    private EmployeeRole role;

}
