package com.nttdata.recruitmentsystem.dto;

import com.nttdata.recruitmentsystem.employee.dto.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Form {

    private String name;
    private String interviewerComment;
    private float averageGrade;
    private ApplicationResponse application;
    private Employee interviewer;

}
