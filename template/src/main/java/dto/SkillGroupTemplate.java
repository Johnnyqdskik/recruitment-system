package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class SkillGroupTemplate {


    private int id;
    private String skillGroupTemplateName;

}
