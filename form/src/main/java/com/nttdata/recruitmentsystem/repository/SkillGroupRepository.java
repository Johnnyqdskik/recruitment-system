package com.nttdata.recruitmentsystem.repository;

import com.nttdata.recruitmentsystem.entity.FormEntity;
import com.nttdata.recruitmentsystem.entity.SkillGroupEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SkillGroupRepository extends CrudRepository<SkillGroupEntity, Integer> {

    @Query("SELECT s FROM SkillGroupEntity s WHERE s.skillName = :skillGroupName")
    Optional<SkillGroupEntity> findByGroupName(String skillGroupName);

    @Query("SELECT f FROM FormEntity f WHERE f.name = :formName")
    List<FormEntity> findByFormName(String formName);

    @Query("SELECT s FROM SkillGroupEntity s WHERE s.skillName = :skillName AND s.form.id = :formId")
    Optional<SkillGroupEntity> findBySkillNameAndForm(String skillName, Integer formId);
}
