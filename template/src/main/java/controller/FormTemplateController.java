package controller;

import dto.FormTemplate;
import entity.FormTemplateEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.FormTemplateService;

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