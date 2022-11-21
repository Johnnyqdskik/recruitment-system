package service;

import dto.SkillGroupTemplate;
import dto.TopicTemplate;
import entity.SkillGroupTemplateEntity;
import entity.TopicTemplateEntity;
import lombok.extern.slf4j.Slf4j;
import mapper.SkillGroupTemplateMapper;
import mapper.TopicTemplateMapper;
import org.springframework.stereotype.Service;
import repository.SkillGroupTemplateRepository;
import repository.TopicTemplateRepository;

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
        Optional<TopicTemplateEntity> existingTopicTemplate= topicTemplateRepository.findById(topicTemplate.getId());
        if(existingTopicTemplate.isPresent()){
            log.warn("Topic template with id {} already exists", topicTemplate.getId());
            throw new IllegalArgumentException("Topic template with id " + topicTemplate.getId() + " already exists");
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
