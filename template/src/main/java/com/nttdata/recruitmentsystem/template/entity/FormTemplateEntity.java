package com.nttdata.recruitmentsystem.template.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(schema = "recruitment_system", name = "form_template")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FormTemplateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "template_id", nullable = false)
    private Integer id;

    @Column(name = "template_name")
    private String formTemplateName;

    @ManyToMany(mappedBy = "formTemplateEntities")
    Set<SkillGroupTemplateEntity> skillGroupTemplateEntities;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "form_topic_template",
            schema = "recruitment_system",
            joinColumns = {@JoinColumn(name = "fk_form_template")},
            inverseJoinColumns = {@JoinColumn(name = "fk_topic_template")}
    )
    Set<TopicTemplateEntity> topicTemplateEntities;
}


