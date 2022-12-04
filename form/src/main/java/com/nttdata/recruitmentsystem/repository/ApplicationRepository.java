package com.nttdata.recruitmentsystem.repository;

import com.nttdata.recruitmentsystem.entity.ApplicationEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplicationRepository extends CrudRepository<ApplicationEntity, Integer> {

    @Query("SELECT app FROM ApplicationEntity app WHERE app.recruiter.id = :recruiterId AND app.candidate.id = :candidateId")
    Optional<ApplicationEntity> findByRecruiterAndCandidate(Integer recruiterId, Integer candidateId);

    @Query("SELECT app FROM ApplicationEntity app JOIN app.recruiter r WHERE r.id = :recruiterId")
    List<ApplicationEntity> findAllByRecruiterId(Integer recruiterId);

}
