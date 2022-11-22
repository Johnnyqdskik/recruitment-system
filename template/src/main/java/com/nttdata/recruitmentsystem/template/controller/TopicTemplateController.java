package com.nttdata.recruitmentsystem.template.controller;

import com.nttdata.recruitmentsystem.template.dto.TopicTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.nttdata.recruitmentsystem.template.service.TopicTemplateService;

import java.util.List;

@RestController
@RequestMapping("api/topic_template")
public class TopicTemplateController {

    private final TopicTemplateService topicTemplateService;

    @Autowired
    public TopicTemplateController(TopicTemplateService topicTemplateService) {
        this.topicTemplateService = topicTemplateService;
    }

    @GetMapping
    public List<TopicTemplate> findAll() {
        return topicTemplateService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> createTopicTemplate(@RequestBody TopicTemplate topicTemplate) {
        topicTemplateService.createTopicTemplate(topicTemplate);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
