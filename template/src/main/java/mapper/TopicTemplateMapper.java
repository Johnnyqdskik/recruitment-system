package mapper;

import dto.SkillGroupTemplate;
import dto.TopicTemplate;
import entity.SkillGroupTemplateEntity;
import entity.TopicTemplateEntity;

public class TopicTemplateMapper {


        public static TopicTemplate mapEntityToDto(TopicTemplateEntity entity) {
            return TopicTemplate.builder()
                    .id(entity.getId())
                    .topicTemplateName(entity.getTopicTemplateName())
                    .build();
        }

        public static TopicTemplateEntity mapDtoToEntity(TopicTemplate t) {
            return TopicTemplateEntity.builder()
                    .id(t.getId())
                    .topicTemplateName(t.getTopicTemplateName())
                    .build();
        }
    }


