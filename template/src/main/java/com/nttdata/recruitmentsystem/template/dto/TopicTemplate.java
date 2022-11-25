package com.nttdata.recruitmentsystem.template.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
public class TopicTemplate {

    int id;
    @NotNull(message = "Field can not be empty,you must enter topic template name")
    @NotBlank(message = "Field can not be empty,you must enter topic template name")
    private String topicTemplateName;
    private int skillGroupTemplateId;

}
