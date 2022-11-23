package com.nttdata.recruitmentsystem.template.mapper;

import com.nttdata.recruitmentsystem.template.dto.TopicTemplate;
import com.nttdata.recruitmentsystem.template.entity.SkillGroupTemplateEntity;
import com.nttdata.recruitmentsystem.template.entity.TopicTemplateEntity;

public class TopicTemplateMapper {


        public static TopicTemplate mapEntityToDto(TopicTemplateEntity entity) {
            return TopicTemplate.builder()
                    .topicTemplateName(entity.getTopicTemplateName())
                    .fk(entity.getId())
                    .build();
        }

        public static TopicTemplateEntity mapDtoToEntity(TopicTemplate t) {
            return TopicTemplateEntity.builder()
                    .topicTemplateName(t.getTopicTemplateName())
                    .build();
        }
    }


