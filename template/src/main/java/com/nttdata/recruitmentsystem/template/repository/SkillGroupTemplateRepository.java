package com.nttdata.recruitmentsystem.template.repository;

import com.nttdata.recruitmentsystem.template.entity.SkillGroupTemplateEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillGroupTemplateRepository extends CrudRepository <SkillGroupTemplateEntity, Integer> {



}
