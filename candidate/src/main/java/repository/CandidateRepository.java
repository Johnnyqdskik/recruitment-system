package repository;

import entity.CandidateEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CandidateRepository extends CrudRepository <CandidateEntity, Integer> {


    Optional<CandidateEntity> findById(Integer id);
    Optional<CandidateEntity> findByEmail(String email);


}
