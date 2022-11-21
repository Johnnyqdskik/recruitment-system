package com.nttdata.repository;

import com.nttdata.entity.ApplicationEntity;
import com.nttdata.recruitmentsystem.candidate.entity.CandidateEntity;
import com.nttdata.recruitmentsystem.employee.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicationRepository extends CrudRepository {

    Optional<ApplicationEntity> findByRecruiterAndCandidate(Optional<EmployeeEntity> userEntity, Optional<CandidateEntity> candidateEntity);

    @Query("SELECT app FROM ApplicationEntity app JOIN app.recruiter r WHERE r.id = :recruiterId")
    Optional<ApplicationEntity> findAllByRecruiterId(Integer recruiterId);

    @Query("SELECT app FROM ApplicationEntity app JOIN app.candidate c WHERE c.id = :candidateId")
    Optional<ApplicationEntity> findAllByCandidateId(Integer candidateId);
}
