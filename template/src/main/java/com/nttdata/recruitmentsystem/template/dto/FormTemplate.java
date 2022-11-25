package com.nttdata.recruitmentsystem.template.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
public class FormTemplate {


    private int id;
    @NotNull (message = "Field can not be empty,you must enter form template name")
    @NotBlank(message = "Field can not be empty,you must enter form template name")
    private String formTemplateName;

}
