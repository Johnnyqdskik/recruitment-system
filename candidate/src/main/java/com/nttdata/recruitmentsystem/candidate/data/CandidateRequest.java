package com.nttdata.recruitmentsystem.candidate.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CandidateRequest {

    private String candidateName;
    private String email;
    private String phoneNumber;

}


