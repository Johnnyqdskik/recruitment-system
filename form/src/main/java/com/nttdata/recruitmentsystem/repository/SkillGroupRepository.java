package com.nttdata.recruitmentsystem.repository;

import com.nttdata.recruitmentsystem.entity.SkillGroupEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SkillGroupRepository extends CrudRepository<SkillGroupEntity, Integer> {

    @Query("SELECT s FROM SkillGroupEntity s WHERE s.skillName = :skillGroupName")
    Optional<SkillGroupEntity> findByName(String skillGroupName);
}
