package com.nttdata.recruitmentsystem.template.mapper;

import com.nttdata.recruitmentsystem.template.dto.SkillGroupTemplate;
import com.nttdata.recruitmentsystem.template.dto.TopicTemplate;
import com.nttdata.recruitmentsystem.template.entity.SkillGroupTemplateEntity;

import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.SqlResultSetMapping;
import java.util.ArrayList;

public class SkillGroupTemplateMapper {

    public static SkillGroupTemplate mapEntityToDto(SkillGroupTemplateEntity entity) {
        return SkillGroupTemplate.builder()
                .id(entity.getId())
                .skillGroupTemplateName(entity.getSkillGroupName())
                .topics(new ArrayList<>())
                .build();
    }

    public static SkillGroupTemplateEntity mapDtoToEntity(SkillGroupTemplate s) {
        return SkillGroupTemplateEntity.builder()
                .skillGroupName(s.getSkillGroupTemplateName())
                .build();
    }

    @SqlResultSetMapping(
            name = "TopicSkillGroupMapping",
            entities = {
                    @EntityResult(
                            entityClass = TopicTemplate.class,
                            fields = {
                                    @FieldResult(name = "id", column = "topic_template_id"),
                                    @FieldResult(name = "topicTemplateName", column = "topic_name"),
                                    @FieldResult(name = "skillGroupTemplateEntity", column = "fk_skill_group_template"),}),

                    @EntityResult(
                            entityClass = SkillGroupTemplate.class,
                            fields = {
                                    @FieldResult(name = "id", column = "skill_group_template_id"),
                                    @FieldResult(name = "skillGroupName", column = "skill_group_name"),
                            })})

}
