package com.nttdata.recruitmentsystem.repository;

import com.nttdata.recruitmentsystem.entity.FormEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FormRepository extends CrudRepository<FormEntity, Integer> {

    @Query("SELECT f FROM FormEntity f WHERE f.interviewer.id = :interviewerId AND f.application.id = :applicationId")
    Optional<FormEntity> findByInterviewerAndApplication(Integer interviewerId, Integer applicationId);

    @Query("SELECT f FROM FormEntity f WHERE f.name = :formName")
    Optional<FormEntity> findByFormName(String formName);

    @Query("SELECT f FROM FormEntity f JOIN f.interviewer i WHERE i.id = :interviewerId")
    Optional<FormEntity> findByInterviewerId(Integer interviewerId);
}
