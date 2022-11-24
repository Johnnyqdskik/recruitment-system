package com.nttdata.recruitmentsystem.candidate.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
public class CandidateRequest {
    @NotBlank
    private String candidateName;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String phoneNumber;

}


