package com.nttdata.entity;

import com.nttdata.dto.EmployeeRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(schema = "", name = "")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "active")
    private boolean active;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private EmployeeRole role;
}
