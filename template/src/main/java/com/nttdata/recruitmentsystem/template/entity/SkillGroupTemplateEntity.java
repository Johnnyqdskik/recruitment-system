package com.nttdata.recruitmentsystem.template.entity;

import lombok.*;
import org.apache.commons.lang3.builder.HashCodeExclude;

import javax.persistence.*;
import java.util.HashSet;
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

    @OneToMany(mappedBy = "skillGroupTemplateEntity", fetch = FetchType.EAGER)
    @ToString.Exclude
    @HashCodeExclude
    private Set<TopicTemplateEntity> topicTemplateEntities;

    @ManyToMany (cascade = { CascadeType.ALL })
    @JoinTable(
            name = "form_skill_group_template",
            schema = "recruitment_system",
            joinColumns = { @JoinColumn(name="fk_skill_group_template") },
            inverseJoinColumns = {@JoinColumn(name = "fk_form_template")}
    )
    @ToString.Exclude
    @HashCodeExclude
    Set<FormTemplateEntity> formTemplateEntities;
}
