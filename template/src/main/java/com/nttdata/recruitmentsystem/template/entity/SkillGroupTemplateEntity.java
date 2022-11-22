package com.nttdata.recruitmentsystem.template.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

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

    @OneToMany(mappedBy = "skillGroupTemplateEntity")
    private Set<TopicTemplateEntity> topicTemplateEntities;

    @ManyToMany
    @JoinTable(
            name = "form_skill_group_template",
            schema = "recruitment_system",
            joinColumns = { @JoinColumn(name="fk_skill_group_template") },
            inverseJoinColumns = {@JoinColumn(name = "fk_form_template")}
    )
    private Set<FormTemplateEntity> formTemplateEntities;
}
