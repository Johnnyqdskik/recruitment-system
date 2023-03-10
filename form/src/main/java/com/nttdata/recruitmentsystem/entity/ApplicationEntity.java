package com.nttdata.recruitmentsystem.entity;

import com.nttdata.recruitmentsystem.employee.entity.EmployeeEntity;
import com.nttdata.recruitmentsystem.candidate.entity.CandidateEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "public", name = "application")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "application_id")
   private int id;

   @Column(name = "creation_date")
   private Date creationDate;

   @Column(name = "recruiter_comment")
   private String recruiterComment;

   @ManyToOne
   @JoinColumn(name = "fk_candidate", nullable = false)
   private CandidateEntity candidate;

   @ManyToOne
   @JoinColumn(name = "fk_recruiter", nullable = false)
   private EmployeeEntity recruiter;
}
