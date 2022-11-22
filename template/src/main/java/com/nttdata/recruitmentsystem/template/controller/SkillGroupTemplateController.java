package com.nttdata.recruitmentsystem.template.controller;

import com.nttdata.recruitmentsystem.template.dto.SkillGroupTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.nttdata.recruitmentsystem.template.service.SkillGroupTemplateService;

import java.util.List;

@RestController
@RequestMapping("api/skill_group_template")
public class SkillGroupTemplateController {

    private final SkillGroupTemplateService skillGroupTemplateService;


    @Autowired
    public SkillGroupTemplateController(SkillGroupTemplateService skillGroupTemplateService) {
        this.skillGroupTemplateService = skillGroupTemplateService;
    }

    @GetMapping
    public List<SkillGroupTemplate> findAll() {
        return skillGroupTemplateService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> createSkillGroupTemplate(@RequestBody SkillGroupTemplate skillGroupTemplate) {
        skillGroupTemplateService.createSkillGroupTemplate(skillGroupTemplate);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
