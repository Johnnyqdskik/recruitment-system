package com.nttdata.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "recruitment_system", name = "candidate")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CandidateEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "candidate_id")
    private Integer id;

    @Column (name = "name")
    private String candidateName;

    @Column (name = "email")
    private String candidateEmail;





}
