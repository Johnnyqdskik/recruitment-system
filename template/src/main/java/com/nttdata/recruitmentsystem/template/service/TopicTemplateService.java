package com.nttdata.recruitmentsystem.template.service;

import com.nttdata.recruitmentsystem.template.dto.TopicTemplate;
import com.nttdata.recruitmentsystem.template.entity.SkillGroupTemplateEntity;
import com.nttdata.recruitmentsystem.template.entity.TopicTemplateEntity;
import com.nttdata.recruitmentsystem.template.mapper.TopicTemplateMapper;
import com.nttdata.recruitmentsystem.template.repository.SkillGroupTemplateRepository;
import com.nttdata.recruitmentsystem.template.repository.TopicTemplateRepository;
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
    private final SkillGroupTemplateRepository skillGroupTemplateRepository;


    public TopicTemplateService(TopicTemplateRepository topicTemplateRepository, SkillGroupTemplateRepository skillGroupTemplateRepository) {
        this.topicTemplateRepository = topicTemplateRepository;

        this.skillGroupTemplateRepository = skillGroupTemplateRepository;
    }

    public void createTopicTemplate(TopicTemplate topicTemplate) {
        Optional<TopicTemplateEntity> existingTopicTemplate=
                topicTemplateRepository.findTopicById(topicTemplate.getId());
        if(existingTopicTemplate.isPresent()){
            log.warn("Topic template with name {} already exists", topicTemplate.getId());
            throw new IllegalArgumentException
                    ("Topic template with id " + topicTemplate.getId() + " already exists");
        }
        Optional<SkillGroupTemplateEntity> skillGroupTemplateEntity
                = skillGroupTemplateRepository.findById(topicTemplate.getFk());
        if(skillGroupTemplateEntity.isPresent()){
            TopicTemplateEntity topicTemplateEntity = TopicTemplateMapper.mapDtoToEntity(topicTemplate);
            topicTemplateEntity.setSkillGroupTemplateEntity(skillGroupTemplateEntity.get());
            topicTemplateRepository.save(topicTemplateEntity);
        }

    }

    public List<TopicTemplate> findAll() {
        Iterable<TopicTemplateEntity> topicTemplateEntities = topicTemplateRepository.findAll();

        List<TopicTemplate> topicTemplates = StreamSupport.stream(topicTemplateEntities.spliterator(), false)
                .map(TopicTemplateMapper::mapEntityToDto)
                .collect(Collectors.toList());

        return topicTemplates;

    }

}
