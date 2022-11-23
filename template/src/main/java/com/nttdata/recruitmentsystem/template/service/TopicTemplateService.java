package com.nttdata.recruitmentsystem.template.service;

import com.nttdata.recruitmentsystem.template.dto.SkillGroupTemplate;
import com.nttdata.recruitmentsystem.template.dto.TopicTemplate;
import com.nttdata.recruitmentsystem.template.entity.SkillGroupTemplateEntity;
import com.nttdata.recruitmentsystem.template.mapper.SkillGroupTemplateMapper;
import com.nttdata.recruitmentsystem.template.mapper.TopicTemplateMapper;
import com.nttdata.recruitmentsystem.template.repository.TopicTemplateRepository;
import com.nttdata.recruitmentsystem.template.entity.TopicTemplateEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Slf4j
public class TopicTemplateService {

    private final TopicTemplateRepository topicTemplateRepository;

    public TopicTemplateService(TopicTemplateRepository topicTemplateRepository, SkillGroupTemplate skillGroupTemplate) {
        this.topicTemplateRepository = topicTemplateRepository;
        this.skillGroupTemplate = skillGroupTemplate;
    }

    public void createTopicTemplate(TopicTemplate topicTemplate) {
        Optional<TopicTemplateEntity> existingTopicTemplate= topicTemplateRepository.findTopicById(topicTemplate.getFk());
        if(existingTopicTemplate.isPresent()){
            log.warn("Topic template with name {} already exists", topicTemplate.getTopicTemplateName());
            throw new IllegalArgumentException("Topic template with name " + topicTemplate.getTopicTemplateName() + " already exists");
        }
        topicTemplateRepository.save(TopicTemplateMapper.mapDtoToEntity(topicTemplate));
    }

    private final SkillGroupTemplate skillGroupTemplate;
    public List<TopicTemplate> findAllTopicsBySkillGroupTemplateName(String topicTemplateName) {
        List<TopicTemplateEntity> allTopicsBySkill =
                StreamSupport.stream(topicTemplateRepository.findAllTopicsBySkillGroupTemplateName
                                (skillGroupTemplate.getSkillGroupTemplateName()).spliterator(), false)
                .collect(Collectors.toList());
        List<TopicTemplate> result =
                topicTemplateRepository.findAllTopicsBySkillGroupTemplateName
                                (skillGroupTemplate.getSkillGroupTemplateName())
                .stream()
                .map(TopicTemplateMapper::mapEntityToDto)
                .collect(Collectors.toList());
        return result;
    }
}
