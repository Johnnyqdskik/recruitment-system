package com.nttdata.recruitmentsystem.service;

import com.nttdata.recruitmentsystem.dto.TopicRequest;
import com.nttdata.recruitmentsystem.entity.TopicEntity;
import com.nttdata.recruitmentsystem.repository.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TopicService {

    private final TopicRepository topicRepository;

    public void createTopic(TopicRequest topicRequest){
        Optional<TopicEntity> existingTopic = topicRepository.findByName(topicRequest.getTopic());

        if(existingTopic.isPresent()){
            throw new IllegalArgumentException("Topic " + topicRequest.getTopic() + " already exists!");
        }

        topicRepository.save(mapDtoToEntity(topicRequest));
    }

    private TopicEntity mapDtoToEntity(TopicRequest topicRequest){
        return TopicEntity.builder()
                .topicName(topicRequest.getTopic())
                .build();
    }
}
