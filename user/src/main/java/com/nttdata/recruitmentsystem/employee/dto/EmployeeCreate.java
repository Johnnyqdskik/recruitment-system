package com.nttdata.recruitmentsystem.employee.dto;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter

public class EmployeeCreate {
    @Email (message = "email must be in correct form")
    private String email;
    @Length(min = 8,message = "password must have min 8 characters")
    private String password;

    @Enumerated(EnumType.STRING)
    private EmployeeRole role;

}
