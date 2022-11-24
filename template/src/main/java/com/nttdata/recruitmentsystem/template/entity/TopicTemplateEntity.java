package com.nttdata.recruitmentsystem.template.entity;

import lombok.*;
import org.apache.commons.lang3.builder.HashCodeExclude;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(schema = "recruitment_system", name = "topic_template")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TopicTemplateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topic_template_id", nullable = false)
    private Integer id;


    @Column (name = "topic_name")
    private String topicTemplateName;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_skill_group_template", nullable = false)
    @ToString.Exclude
    @HashCodeExclude
    private SkillGroupTemplateEntity skillGroupTemplateEntity;

    @ManyToMany(mappedBy = "topicTemplateEntities")
    @ToString.Exclude
    @HashCodeExclude
    Set<FormTemplateEntity> formTemplateEntities;
}
