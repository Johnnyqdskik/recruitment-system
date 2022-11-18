package com.nttdata.recruitmentsystem.candidate.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.GeneratedValue;

@Data
@Builder
@AllArgsConstructor
public class Candidate {



    private String candidateName;
    private String email;
    private String phoneNumber;




}
