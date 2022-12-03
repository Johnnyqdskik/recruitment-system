package com.nttdata.recruitmentsystem.service;

import com.nttdata.recruitmentsystem.dto.Application;
import com.nttdata.recruitmentsystem.employee.dto.Employee;
import com.nttdata.recruitmentsystem.employee.entity.EmployeeEntity;
import com.nttdata.recruitmentsystem.employee.service.Mapper;
import com.nttdata.recruitmentsystem.entity.ApplicationEntity;

public class ApplicationMapper {

    public static Application mapEntityToDto (ApplicationEntity application){
        return Application.builder()
                .id(application.getId())
                .candidate(application.getCandidate())
                .recruiter(Mapper.mapEntityToDto(application.getRecruiter()))
                .creationDate(application.getCreationDate())
                .build();
    }
}
