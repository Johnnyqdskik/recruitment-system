package com.nttdata.recruitmentsystem.employee.repository;

import com.nttdata.recruitmentsystem.employee.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeEntity,Integer> {
    Optional<EmployeeEntity> findByEmail(String email);

    @Query ("SELECT p FROM EmployeeEntity p WHERE p.role= com.nttdata.recruitmentsystem.employee.dto.EmployeeRole.RECRUITER")
    List<EmployeeEntity> findAllAdmins();

}
