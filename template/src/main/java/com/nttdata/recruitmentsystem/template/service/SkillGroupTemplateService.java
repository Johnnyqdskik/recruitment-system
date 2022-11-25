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

import javax.persistence.EntityNotFoundException;
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
        Optional<SkillGroupTemplateEntity> existingSkillGroupTemplate =
                skillGroupTemplateRepository.findById(skillGroupTemplate.getId());
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
        return skillGroups;
    }

    public SkillGroupTemplate updateSkillGroup(Integer groupId, SkillGroupTemplate dto) {
        SkillGroupTemplateEntity skillGroupEntity = skillGroupTemplateRepository.findById(groupId).orElseThrow(EntityNotFoundException::new);
        skillGroupEntity.setSkillGroupName(dto.getSkillGroupTemplateName());

        return SkillGroupTemplateMapper.mapEntityToDto(skillGroupTemplateRepository.save(skillGroupEntity));
    }
    public void deleteSkillGroup(Integer groupId) {
        SkillGroupTemplateEntity skillGroupEntity = skillGroupTemplateRepository.findById(groupId).orElseThrow(EntityNotFoundException::new);

        skillGroupTemplateRepository.delete(skillGroupEntity);
    }
    public SkillGroupTemplate assignSkillTopicToSkillGroup(Integer groupId, Integer topicId) {
        SkillGroupTemplateEntity skillGroupEntity = skillGroupTemplateRepository.findById(groupId).orElseThrow(EntityNotFoundException::new);
        TopicTemplateEntity skillTopicEntity = topicTemplateRepository.findById(topicId).orElseThrow(EntityNotFoundException::new);

        skillGroupEntity.getTopicTemplateEntities().add(skillTopicEntity);
        return SkillGroupTemplateMapper.mapEntityToDto(skillGroupTemplateRepository.save(skillGroupEntity));
    }

}

