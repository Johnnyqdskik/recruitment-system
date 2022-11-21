package repository;

import entity.FormTemplateEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FormTemplateRepository extends CrudRepository <FormTemplateEntity, Integer> {

    Optional<FormTemplateEntity> findById(Integer id);
}
