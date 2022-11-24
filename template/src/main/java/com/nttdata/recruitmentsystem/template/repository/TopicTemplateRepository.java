package com.nttdata.recruitmentsystem.template.repository;

import com.nttdata.recruitmentsystem.template.dto.SkillGroupTemplate;
import com.nttdata.recruitmentsystem.template.dto.TopicTemplate;
import com.nttdata.recruitmentsystem.template.entity.SkillGroupTemplateEntity;
import com.nttdata.recruitmentsystem.template.entity.TopicTemplateEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.SqlResultSetMapping;
import java.util.List;
import java.util.Optional;

@Repository
public interface TopicTemplateRepository extends CrudRepository <TopicTemplateEntity, Integer> {

    Optional<TopicTemplateEntity> findTopicById(Integer id);


    @Query("SELECT t.topic_template_id, t.topic_name, t.fk_skill_group_template, " +
            "s.skill_group_template_id, s.skill_group_name FROM TopicTemplate t " +
            "JOIN SkillGroupTemplate s ON t.fk_skill_group_template = s.skill_group_template_id")
    List<TopicTemplateEntity> findAllTopicsBySkillGroupTemplateName(String skillGroupTemplateName);


}