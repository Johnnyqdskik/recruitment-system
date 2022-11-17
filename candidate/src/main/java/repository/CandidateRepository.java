package repository;

import entity.CandidateEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CandidateRepository extends CrudRepository <CandidateEntity, Integer> {


    Optional<CandidateEntity> findByFirstName(String firstName);
    Optional<CandidateEntity> findByLastName(String lastName);
    Optional<CandidateEntity> findBySsn(Integer ssn);

}
