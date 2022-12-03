package com.nttdata.recruitmentsystem.template.dto;

import lombok.*;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
    @NotNull(message = "Field can not be empty, you must enter skill group template name")
    @NotBlank(message = "Field can not be empty, you must enter skill group template name")
    private String skillGroupTemplateName;
    private List<TopicTemplate> topics;
}
