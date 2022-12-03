package com.nttdata.recruitmentsystem.dto;

import com.nttdata.recruitmentsystem.employee.dto.Employee;
import com.nttdata.recruitmentsystem.template.dto.FormTemplate;
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
    private String comment;
    private float averageGrade;
    private Application application;
    private Employee interviewer;

}
