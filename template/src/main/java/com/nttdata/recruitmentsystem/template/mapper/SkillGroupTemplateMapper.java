package com.nttdata.recruitmentsystem.template.mapper;

import com.nttdata.recruitmentsystem.template.dto.SkillGroupTemplate;
import com.nttdata.recruitmentsystem.template.entity.SkillGroupTemplateEntity;

public class SkillGroupTemplateMapper {

    public static SkillGroupTemplate mapEntityToDto(SkillGroupTemplateEntity entity) {
        return SkillGroupTemplate.builder()
                .id(entity.getId())
                .skillGroupTemplateName(entity.getSkillGroupName())
                .build();
    }

    public static SkillGroupTemplateEntity mapDtoToEntity(SkillGroupTemplate s) {
        return SkillGroupTemplateEntity.builder()
                .skillGroupName(s.getSkillGroupTemplateName())
                .build();
    }
}
