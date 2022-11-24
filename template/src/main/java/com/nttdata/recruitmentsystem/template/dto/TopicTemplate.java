package com.nttdata.recruitmentsystem.template.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class TopicTemplate {

    int id;
    private String topicTemplateName;
    private int fk;

}
