package com.nttdata.recruitmentsystem.template.repository;

import com.nttdata.recruitmentsystem.template.entity.FormTemplateEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FormTemplateRepository extends CrudRepository <FormTemplateEntity, Integer> {

    Optional<FormTemplateEntity> findById(Integer id);
}
