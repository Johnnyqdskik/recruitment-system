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
    @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    @Column(name = "id")
    private UUID id;   //TODO: PITAJ ROBERTA ?

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
