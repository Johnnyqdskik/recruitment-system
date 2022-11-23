package com.nttdata.recruitmentsystem.employee.repository;

import com.nttdata.recruitmentsystem.employee.dto.EmployeeRole;
import com.nttdata.recruitmentsystem.employee.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeEntity,Integer> {
    Optional<EmployeeEntity> findByEmail(String email);

    Optional<EmployeeEntity> findById(Integer id);

    @Query ("SELECT e FROM EmployeeEntity e WHERE e.role=:role AND e.role IN (com.nttdata.recruitmentsystem.employee.dto.EmployeeRole.RECRUITER, com.nttdata.recruitmentsystem.employee.dto.EmployeeRole.INTERVIEWER)")
    List<EmployeeEntity> findAllByRole(EmployeeRole role);

}
