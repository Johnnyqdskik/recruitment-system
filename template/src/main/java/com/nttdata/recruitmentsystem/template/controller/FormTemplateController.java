package com.nttdata.recruitmentsystem.template.controller;

import com.nttdata.recruitmentsystem.template.dto.FormTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.nttdata.recruitmentsystem.template.service.FormTemplateService;

import java.util.List;

@RestController
@RequestMapping("api/form_template")
public class FormTemplateController {


    private final FormTemplateService formTemplateService;


    @Autowired
    public FormTemplateController(FormTemplateService formTemplateService) {
        this.formTemplateService = formTemplateService;
    }

    @GetMapping
    public List<FormTemplate> findAll() {
        return formTemplateService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> createFormTemplate (@RequestBody FormTemplate formTemplate) {
    formTemplateService.createFormTemplate(formTemplate);
    return new ResponseEntity<>(HttpStatus.OK);
}
}