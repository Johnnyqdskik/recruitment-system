package com.nttdata.recruitmentsystem.candidate.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.validation.constraints.Email;

@Data
@Builder
@AllArgsConstructor
public class Candidate {

    private Integer id;
    private String candidateName;
    @Email
    private String email;
    private String phoneNumber;

}
