package com.nttdata.recruitmentsystem.template.dto;

import lombok.*;


import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class SkillGroupTemplate {


    private int id;
    private String skillGroupTemplateName;
    private List<TopicTemplate> topics;
}
