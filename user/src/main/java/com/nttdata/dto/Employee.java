package com.nttdata.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Employee {
    @NotEmpty(message = "Username can not be empty")
    private String email;
    private String password;
    private String role;
    private boolean active;
}
