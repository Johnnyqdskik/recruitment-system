package com.nttdata.recruitmentsystem.template.controller;

import com.nttdata.recruitmentsystem.template.dto.FormTemplate;
import com.nttdata.recruitmentsystem.template.dto.SkillGroupTemplate;
import com.nttdata.recruitmentsystem.template.dto.TopicTemplate;
import com.nttdata.recruitmentsystem.template.service.FormTemplateService;
import com.nttdata.recruitmentsystem.template.service.SkillGroupTemplateService;
import com.nttdata.recruitmentsystem.template.service.TopicTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/template")
public class TemplateController {

    private final FormTemplateService formTemplateService;
    private final SkillGroupTemplateService skillGroupTemplateService;
    private final TopicTemplateService topicTemplateService;

    private final TopicTemplate topicTemplate;
    private final SkillGroupTemplate skillGroupTemplate;


    @Autowired
    public TemplateController(FormTemplateService formTemplateService, SkillGroupTemplateService skillGroupTemplateService, TopicTemplateService topicTemplateService, TopicTemplate topicTemplate, SkillGroupTemplate skillGroupTemplate) {
        this.formTemplateService = formTemplateService;
        this.skillGroupTemplateService = skillGroupTemplateService;
        this.topicTemplateService = topicTemplateService;
        this.topicTemplate = topicTemplate;
        this.skillGroupTemplate = skillGroupTemplate;
    }

    @GetMapping("/form")
    public List<FormTemplate> findAllFormTemplates() {
        return formTemplateService.findAll();
    }

    @GetMapping("/skill_group_template")
    public List<SkillGroupTemplate> findAllSkills() {
        return skillGroupTemplateService.findAll();
    }

//    @GetMapping("/skill_group_template")
//    public List<TopicTemplate> findAllTopics() {return topicTemplateService
//            .findAllTopicsBySkillGroupTemplateName
//            (skillGroupTemplate.getSkillGroupTemplateName());
//    }

    @PostMapping("/form")
    public ResponseEntity<?> createFormTemplate(@RequestBody FormTemplate formTemplate) {
        formTemplateService.createFormTemplate(formTemplate);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PostMapping("/skill_group_template")
    public ResponseEntity<?> createSkillGroupTemplate(@RequestBody SkillGroupTemplate skillGroupTemplate) {
        skillGroupTemplateService.createSkillGroupTemplate(skillGroupTemplate);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/skill_group_template/topics")
    public ResponseEntity<?> createTopicTemplate(@RequestBody TopicTemplate topicTemplate) {
        topicTemplateService.createTopicTemplate(topicTemplate);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}