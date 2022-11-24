package com.nttdata.recruitmentsystem.template.mapper;

import com.nttdata.recruitmentsystem.template.dto.TopicTemplate;
import com.nttdata.recruitmentsystem.template.entity.TopicTemplateEntity;

public class TopicTemplateMapper {

    public static TopicTemplate mapEntityToDto(TopicTemplateEntity entity) {
        return TopicTemplate.builder()
                .id(entity.getId())
                .topicTemplateName(entity.getTopicTemplateName())
                .build();
    }

    public static TopicTemplateEntity mapDtoToEntity(TopicTemplate t) {
        return TopicTemplateEntity.builder()
                .topicTemplateName(t.getTopicTemplateName())
                .skillGroupTemplateEntity(null)
                .build();
    }
}


