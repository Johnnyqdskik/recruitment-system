package com.nttdata.recruitmentsystem.candidate.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(schema = "public", name = "candidate")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CandidateEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "candidate_id")
    private Integer id;

    @Column (name = "name")
    private String candidateName;

    @Column (name = "email")
    private String email;

    @Column (name = "phone_number")
    private String phoneNumber;





}
