package com.nttdata.recruitmentsystem.dto;

import com.nttdata.recruitmentsystem.candidate.data.Candidate;
import com.nttdata.recruitmentsystem.candidate.entity.CandidateEntity;
import com.nttdata.recruitmentsystem.employee.dto.Employee;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ApplicationResponse {

    private Integer id;
    private Candidate candidate;
    private Employee recruiter;
    private FormHeader form;
    private Date creationDate;
    private String recruiterComment;
}
