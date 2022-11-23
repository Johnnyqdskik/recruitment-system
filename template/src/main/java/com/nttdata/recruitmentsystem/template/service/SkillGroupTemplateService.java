package com.nttdata.recruitmentsystem.template.service;

import com.nttdata.recruitmentsystem.template.dto.SkillGroupTemplate;
import com.nttdata.recruitmentsystem.template.dto.TopicTemplate;
import com.nttdata.recruitmentsystem.template.entity.TopicTemplateEntity;
import com.nttdata.recruitmentsystem.template.mapper.SkillGroupTemplateMapper;
import com.nttdata.recruitmentsystem.template.mapper.TopicTemplateMapper;
import com.nttdata.recruitmentsystem.template.repository.SkillGroupTemplateRepository;
import com.nttdata.recruitmentsystem.template.entity.SkillGroupTemplateEntity;
import com.nttdata.recruitmentsystem.template.repository.TopicTemplateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Slf4j
public class SkillGroupTemplateService {

    private final SkillGroupTemplateRepository skillGroupTemplateRepository;
    private final TopicTemplateRepository topicTemplateRepository;

    public SkillGroupTemplateService(SkillGroupTemplateRepository skillGroupTemplateRepository, TopicTemplateRepository topicTemplateRepository) {
        this.skillGroupTemplateRepository = skillGroupTemplateRepository;
        this.topicTemplateRepository = topicTemplateRepository;
    }

    public void createSkillGroupTemplate(SkillGroupTemplate skillGroupTemplate) {
        Optional<SkillGroupTemplateEntity> existingSkillGroupTemplate = skillGroupTemplateRepository.findById(skillGroupTemplate.getId());
        if (existingSkillGroupTemplate.isPresent()) {
            log.warn("Skill group with id {} already exists", skillGroupTemplate.getId());
            throw new IllegalArgumentException("Skill group with id " + skillGroupTemplate.getId() + " already exists");
        }
        skillGroupTemplateRepository.save(SkillGroupTemplateMapper.mapDtoToEntity(skillGroupTemplate));
    }

    public List<SkillGroupTemplate> findAll() {
        Iterable<SkillGroupTemplateEntity> skillGroupTemplateEntities = skillGroupTemplateRepository.findAll();

        List<SkillGroupTemplate> skillGroups = StreamSupport.stream(skillGroupTemplateEntities.spliterator(), false)
                .map(SkillGroupTemplateMapper::mapEntityToDto)
                .collect(Collectors.toList());


        for (SkillGroupTemplate e:skillGroups) {
            List<TopicTemplateEntity> topicEntities = topicTemplateRepository.findAllTopicsBySkillGroupTemplateName(e.getSkillGroupTemplateName());
            List<TopicTemplate> topics = topicEntities.stream()
                    .map(TopicTemplateMapper::mapEntityToDto)
                    .collect(Collectors.toList());

            e.setTopics(topics);

        }

        return skillGroups;
//        List<SkillGroupTemplate> skillGroupTemplates = StreamSupport.stream
//                        (skillGroupTemplateEntities.spliterator(), false)
//                .map(SkillGroupTemplateMapper::mapEntityToDto)
//                .collect(Collectors.toList());
//        return skillGroupTemplates;
    }

}

