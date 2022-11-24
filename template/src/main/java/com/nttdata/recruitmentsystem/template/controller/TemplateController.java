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

    private final TopicTemplateService topicTemplateService;
    private final SkillGroupTemplateService skillGroupTemplateService;


    @Autowired
    public TemplateController(FormTemplateService formTemplateService, TopicTemplateService topicTemplateService, SkillGroupTemplateService skillGroupTemplateService) {
        this.formTemplateService = formTemplateService;
        this.topicTemplateService = topicTemplateService;
        this.skillGroupTemplateService = skillGroupTemplateService;

    }

    @GetMapping("/form")
    public List<FormTemplate> findAllFormTemplates() {
        return formTemplateService.findAll();
    }


    @GetMapping("/skill_group")
    public List<SkillGroupTemplate> findAllSkillGroups() {return skillGroupTemplateService.findAll();
    }

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