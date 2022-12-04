package com.nttdata.recruitmentsystem.dto;

import lombok.Data;

@Data
public class FormCreateRequest {

    private Integer applicationId;
    private Integer interviewerId;
    private Integer templateId;

}
