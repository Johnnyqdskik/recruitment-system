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





}

//@SqlResultSetMapping(
//        name = "TopicSkillGroupMapping",
//        entities = {
//                @EntityResult(
//                        entityClass = TopicTemplate.class,
//                        fields = {
//                                @FieldResult(name = "id", column = "topic_template_id"),
//                                @FieldResult(name = "topicTemplateName", column = "topic_name"),
//                                @FieldResult(name = "skillGroupTemplateEntity", column = "fk_skill_group_template"),}),
//
//                @EntityResult(
//                        entityClass = SkillGroupTemplate.class,
//                        fields = {
//                                @FieldResult(name = "id", column = "skill_group_template_id"),
//                                @FieldResult(name = "skillGroupName", column = "skill_group_name"),
//                        })})
