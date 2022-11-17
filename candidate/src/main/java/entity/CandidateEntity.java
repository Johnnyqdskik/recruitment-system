package entity;


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

    @Column (name = "first_name")
    private String candidateFirstName;

    @Column (name = "last_name")
    private String candidateLastName;

    @Column (name = "ssn")
    private Integer ssn;



}
