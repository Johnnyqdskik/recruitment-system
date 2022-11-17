package com.nttdata.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {
    @NotEmpty(message = "Username can not be empty")
    private String username;
    private String password;
    private String role;
}
