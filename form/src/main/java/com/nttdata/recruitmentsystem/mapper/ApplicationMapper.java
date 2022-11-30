package com.nttdata.recruitmentsystem.mapper;

import com.nttdata.recruitmentsystem.candidate.mapper.CandidateMapper;
import com.nttdata.recruitmentsystem.dto.ApplicationResponse;
import com.nttdata.recruitmentsystem.employee.service.EmployeeMapper;
import com.nttdata.recruitmentsystem.entity.ApplicationEntity;

public class ApplicationMapper {

    public static ApplicationResponse mapEntityToDto (ApplicationEntity application){
        return ApplicationResponse.builder()
                .id(application.getId())
                .candidate(CandidateMapper.mapEntityToDto(application.getCandidate()))
                .recruiter(EmployeeMapper.mapEntityToDto(application.getRecruiter()))
                .creationDate(application.getCreationDate())
                .build();
    }
}
