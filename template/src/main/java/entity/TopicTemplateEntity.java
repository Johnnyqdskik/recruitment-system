package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "recruitment_system", name = "form_template")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TopicTemplateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topic_template_id", nullable = false)
    private Integer id;


    @Column (name = "topic_template_name")
    private String topicTemplateName;

    @ManyToOne
    @JoinColumn(name = "fk_skill_group_template", nullable = false)
    private SkillGroupTemplateEntity skillGroupTemplateEntity;
}
