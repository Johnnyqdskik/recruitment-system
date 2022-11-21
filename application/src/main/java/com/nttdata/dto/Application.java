package com.nttdata.dto;

import com.nttdata.recruitmentsystem.candidate.entity.CandidateEntity;
import com.nttdata.recruitmentsystem.employee.entity.EmployeeEntity;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Application {

    private CandidateEntity candidate;
    private EmployeeEntity recruiter;
    private Date creationDate;

}
