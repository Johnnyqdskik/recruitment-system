package com.nttdata.recruitmentsystem.employee.dto;

import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter

public class Employee {
    private int id;
    private String email;
    private String password;
    private boolean active;

    @Enumerated(EnumType.STRING)
    private EmployeeRole role;

}
