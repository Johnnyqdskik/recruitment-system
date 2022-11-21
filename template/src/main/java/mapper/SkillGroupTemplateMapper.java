package mapper;

import dto.FormTemplate;
import dto.SkillGroupTemplate;
import entity.FormTemplateEntity;
import entity.SkillGroupTemplateEntity;

public class SkillGroupTemplateMapper {

    public static SkillGroupTemplate mapEntityToDto(SkillGroupTemplateEntity entity) {
        return SkillGroupTemplate.builder()
                .id(entity.getId())
                .skillGroupTemplateName(entity.getSkillGroupName())
                .build();
    }

    public static SkillGroupTemplateEntity mapDtoToEntity(SkillGroupTemplate s) {
        return SkillGroupTemplateEntity.builder()
                .id(s.getId())
                .skillGroupName(s.getSkillGroupTemplateName())
                .build();
    }
}
