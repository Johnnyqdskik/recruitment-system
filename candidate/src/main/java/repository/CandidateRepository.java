package repository;

import entity.CandidateEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CandidateRepository extends CrudRepository <CandidateEntity, Integer> {


    Optional<CandidateEntity> findByName(String name);
    Optional<CandidateEntity> findByEmail(String email);


}
