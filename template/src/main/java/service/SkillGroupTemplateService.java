package service;

import dto.FormTemplate;
import dto.SkillGroupTemplate;
import entity.FormTemplateEntity;
import entity.SkillGroupTemplateEntity;
import lombok.extern.slf4j.Slf4j;
import mapper.FormTemplateMapper;
import mapper.SkillGroupTemplateMapper;
import org.springframework.stereotype.Service;
import repository.SkillGroupTemplateRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Slf4j
public class SkillGroupTemplateService {

    private final SkillGroupTemplateRepository skillGroupTemplateRepository;

    public SkillGroupTemplateService(SkillGroupTemplateRepository skillGroupTemplateRepository) {
        this.skillGroupTemplateRepository = skillGroupTemplateRepository;
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

        List<SkillGroupTemplate> skillGroupTemplates = StreamSupport.stream
                        (skillGroupTemplateEntities.spliterator(), false)
                .map(SkillGroupTemplateMapper::mapEntityToDto)
                .collect(Collectors.toList());
        return skillGroupTemplates;
    }
}
