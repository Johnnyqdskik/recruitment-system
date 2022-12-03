package com.nttdata.recruitmentsystem.repository;

import com.nttdata.recruitmentsystem.entity.TopicEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TopicRepository extends CrudRepository<TopicEntity, Integer> {

    @Query("SELECT t FROM TopicEntity t WHERE t.topicName = :topicName")
    Optional<TopicEntity> findByName(String topicName);
}
