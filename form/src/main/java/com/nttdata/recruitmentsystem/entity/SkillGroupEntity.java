package com.nttdata.recruitmentsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(schema = "recruitment_system", name = "skill_group")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SkillGroupEntity {

    @Id
    @Column(name = "skill_group_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "skill_name")
    private String skillName;

    @Column(name = "average_grade")
    private float averageGrade;

    @ManyToOne
    @JoinColumn(name = "fk_form")
    private FormEntity form;

    @OneToMany(mappedBy = "skillGroup")
    private Set<TopicEntity> topics;
}
