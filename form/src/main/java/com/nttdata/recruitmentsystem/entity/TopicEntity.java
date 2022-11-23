package com.nttdata.recruitmentsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "recruitment_system", name = "topic")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TopicEntity {

    @Id
    @Column(name = "topic_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "topic_name")
    private String topicName;

    @Column(name = "grade")
    private Integer grade;

    @Column(name = "comment")
    private String comment;

    @Column(name = "mandatory")
    private boolean mandatory;

    @ManyToOne
    @JoinColumn(name = "fk_skill_group")
    private SkillGroupEntity skillGroup;
}
