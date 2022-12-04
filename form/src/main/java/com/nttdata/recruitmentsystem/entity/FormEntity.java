package com.nttdata.recruitmentsystem.entity;

import com.nttdata.recruitmentsystem.employee.entity.EmployeeEntity;
import com.nttdata.recruitmentsystem.entity.ApplicationEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(schema = "public", name = "form")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FormEntity {

    @Id
    @Column(name = "form_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "average_grade")
    private Float averageGrade;

    @Column(name = "interviewer_comment")
    private String comment;

    @OneToOne
    @JoinColumn(name = "fk_application")
    private ApplicationEntity application;

    @ManyToOne
    @JoinColumn(name = "fk_interviewer")
    private EmployeeEntity interviewer;

    @OneToMany(mappedBy = "form", cascade = CascadeType.ALL)
    private Set<SkillGroupEntity> skillGroups;

}
