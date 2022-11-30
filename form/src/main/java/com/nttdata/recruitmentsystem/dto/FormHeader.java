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
public class FormHeader {

    private Integer id;
    private String name;
    private Employee interviewer;
    private String interviewerComment;

}
