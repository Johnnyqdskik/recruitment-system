package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "recruitment_system", name = "skill_group_template")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SkillGroupTemplateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_group_template_id", nullable = false)
    private Integer id;

    @Column (name = "skill_group_name")
    private String skillGroupName;
}
