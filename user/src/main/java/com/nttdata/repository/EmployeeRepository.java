package com.nttdata.repository;

import com.nttdata.entity.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Integer> {
    Optional<EmployeeEntity> findByEmail(String email);

    List<EmployeeEntity> findAllAdmins();
}
