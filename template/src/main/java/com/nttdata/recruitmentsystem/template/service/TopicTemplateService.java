package com.nttdata.recruitmentsystem.template.service;

import com.nttdata.recruitmentsystem.template.dto.TopicTemplate;
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

    public TopicTemplateService(TopicTemplateRepository topicTemplateRepository) {
        this.topicTemplateRepository = topicTemplateRepository;
    }

    public void createTopicTemplate(TopicTemplate topicTemplate) {
        Optional<TopicTemplateEntity> existingTopicTemplate= topicTemplateRepository.findByTopicTemplateName(topicTemplate.getTopicTemplateName());
        if(existingTopicTemplate.isPresent()){
            log.warn("Topic template with name {} already exists", topicTemplate.getTopicTemplateName());
            throw new IllegalArgumentException("Topic template with name " + topicTemplate.getTopicTemplateName() + " already exists");
        }
        topicTemplateRepository.save(TopicTemplateMapper.mapDtoToEntity(topicTemplate));
    }
    public List<TopicTemplate> findAll() {
        Iterable<TopicTemplateEntity> topicTemplateEntities = topicTemplateRepository.findAll();

        List<TopicTemplate> topicTemplates = StreamSupport.stream
                        (topicTemplateEntities.spliterator(), false)
                .map(TopicTemplateMapper::mapEntityToDto)
                .collect(Collectors.toList());
        return topicTemplates;
    }
}
