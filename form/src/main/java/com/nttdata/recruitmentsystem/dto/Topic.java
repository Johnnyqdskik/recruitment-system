package com.nttdata.recruitmentsystem.dto;

import com.nttdata.recruitmentsystem.entity.SkillGroupEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Topic {

    private String topicName;
    private Integer grade;
    private String comment;
    private boolean mandatory;
    private SkillGroupEntity skillGroup;
}
