package com.nttdata.recruitmentsystem.template.repository;

import com.nttdata.recruitmentsystem.template.entity.SkillGroupTemplateEntity;
import com.nttdata.recruitmentsystem.template.entity.TopicTemplateEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TopicTemplateRepository extends CrudRepository <TopicTemplateEntity, Integer> {

    Optional<TopicTemplateEntity> findTopicById(Integer id);

    @Query("SELECT skill.topic FROM SkillGroupTemplateEntity skill JOIN skill.topicTemplateEntities t WHERE skill.skillGroupName = :skillGroupTemplateName")
    List<TopicTemplateEntity> findAllTopicsBySkillGroupTemplateName(String skillGroupTemplateName);
}
