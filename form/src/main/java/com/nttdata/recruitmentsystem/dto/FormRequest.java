package com.nttdata.recruitmentsystem.dto;

import lombok.Data;

@Data
public class FormRequest {

    private Integer applicationId;
    private Integer interviewerId;
    private Integer templateId;
    private String formName;
}
