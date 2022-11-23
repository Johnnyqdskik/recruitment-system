package com.nttdata.recruitmentsystem.dto;

import com.nttdata.recruitmentsystem.entity.FormEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SkillGroup {

    private String skillName;
    private float averageGrade;
    private FormEntity form;
}
