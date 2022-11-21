package com.nttdata.recruitmentsystem.employee.entity;

import com.nttdata.recruitmentsystem.employee.dto.EmployeeRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "recruitment_system", name = "employee")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "active")
    private boolean active = true;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private EmployeeRole role;
}
