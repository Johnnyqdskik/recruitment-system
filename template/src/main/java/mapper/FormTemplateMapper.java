package mapper;

import dto.FormTemplate;
import entity.FormTemplateEntity;

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
                .id(formTemplate.getId())
                .build();
    }
}
