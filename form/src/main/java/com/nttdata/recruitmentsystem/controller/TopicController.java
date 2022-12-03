package com.nttdata.recruitmentsystem.controller;

import com.nttdata.recruitmentsystem.dto.TopicRequest;
import com.nttdata.recruitmentsystem.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/topics")
public class TopicController {

    private final TopicService topicService;

    @PostMapping
    private ResponseEntity<?> createTopic(@RequestBody TopicRequest topicRequest){
        topicService.createTopic(topicRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
