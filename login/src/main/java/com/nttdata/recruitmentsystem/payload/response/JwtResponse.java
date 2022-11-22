package com.nttdata.recruitmentsystem.payload.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtResponse {

    private String accessToken;
    private String type = "Bearer";
    private String email;
    private String role;

    public JwtResponse(String accessToken, String email, String role) {
        this.accessToken = accessToken;
        this.email = email;
        this.role = role;
    }
}
