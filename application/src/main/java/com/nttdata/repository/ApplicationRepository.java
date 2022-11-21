package com.nttdata.repository;

import com.nttdata.entity.ApplicationEntity;
import com.nttdata.recruitmentsystem.candidate.entity.CandidateEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicationRepository extends CrudRepository {

    Optional<ApplicationEntity> findByRecruiterAndCandidate(UserEntity userEntity, Optional<CandidateEntity> candidateEntity);

    @Query("SELECT app FROM ApplicationEntity app JOIN app.recruiter r WHERE r.userName = :recruiterName")
    Optional<ApplicationEntity> findAllByRecruiterName(String recruiterName);

    @Query("SELECT app FROM ApplicationEntity app JOIN app.candidate c WHERE c.userName = :candidateName")
    Optional<ApplicationEntity> findAllByCandidateName(String candidateName);
}
