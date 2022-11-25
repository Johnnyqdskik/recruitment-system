package com.nttdata.recruitmentsystem.template.mapper;

import com.nttdata.recruitmentsystem.template.dto.FormTemplate;
import com.nttdata.recruitmentsystem.template.entity.FormTemplateEntity;

public class FormTemplateMapper {

    public static FormTemplate mapEntityToDto(FormTemplateEntity entity){
        return FormTemplate.builder()
                .id(entity.getId())
                .formTemplateName(entity.getFormTemplateName())
                .build();
    }
    public static FormTemplateEntity mapDtoToEntity(FormTemplate formTemplate) {
        return FormTemplateEntity.builder()
                .formTemplateName(formTemplate.getFormTemplateName())
                .build();
    }
}
