package com.nttdata.recruitmentsystem.template.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class SkillGroupTemplate {


    private int id;
    private String skillGroupTemplateName;
    private List<TopicTemplate> topics;
}
