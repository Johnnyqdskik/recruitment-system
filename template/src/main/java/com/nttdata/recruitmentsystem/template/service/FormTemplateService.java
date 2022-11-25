package com.nttdata.recruitmentsystem.template.service;

import com.nttdata.recruitmentsystem.template.dto.FormTemplate;
import com.nttdata.recruitmentsystem.template.mapper.FormTemplateMapper;
import com.nttdata.recruitmentsystem.template.repository.FormTemplateRepository;
import com.nttdata.recruitmentsystem.template.entity.FormTemplateEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Slf4j
public class FormTemplateService {


    private final FormTemplateRepository formTemplateRepository;

    public FormTemplateService(FormTemplateRepository formTemplateRepository) {
        this.formTemplateRepository = formTemplateRepository;
    }

    public void createFormTemplate(FormTemplate formTemplate) {
        Optional<FormTemplateEntity> existingFormTemplate=formTemplateRepository.findById(formTemplate.getId());
        if(existingFormTemplate.isPresent()){
            log.warn("Form with id {} already exists", formTemplate.getId());
            throw new IllegalArgumentException("Form with id " + formTemplate.getId() + " already exists");
        }
        formTemplateRepository.save(FormTemplateMapper.mapDtoToEntity(formTemplate));
    }
    public List<FormTemplate> findAll(){
        Iterable<FormTemplateEntity> formTemplateEntities = formTemplateRepository.findAll();

        List<FormTemplate> formTemplates= StreamSupport.stream(formTemplateEntities.spliterator(), false)
                .map(FormTemplateMapper::mapEntityToDto)
                .collect(Collectors.toList());
        return formTemplates;
    }
}
