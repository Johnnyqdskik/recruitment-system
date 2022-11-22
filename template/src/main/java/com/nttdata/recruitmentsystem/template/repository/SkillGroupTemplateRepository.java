package com.nttdata.recruitmentsystem.template.repository;

import com.nttdata.recruitmentsystem.template.entity.SkillGroupTemplateEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillGroupTemplateRepository extends CrudRepository <SkillGroupTemplateEntity, Integer> {
}
