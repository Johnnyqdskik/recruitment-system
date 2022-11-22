package com.nttdata.recruitmentsystem.template.repository;

import com.nttdata.recruitmentsystem.template.entity.TopicTemplateEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TopicTemplateRepository extends CrudRepository <TopicTemplateEntity, Integer> {

    Optional<TopicTemplateEntity> findByTopicTemplateName(String topicTemplateName);




}
