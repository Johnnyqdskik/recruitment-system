package com.nttdata.dto;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotEmpty;
import java.util.UUID;

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
    private Integer logCount;


}
