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

public class EmployeeCreate {
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private EmployeeRole role;

}
