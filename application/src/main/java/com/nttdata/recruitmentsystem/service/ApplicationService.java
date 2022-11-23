package com.nttdata.recruitmentsystem.service;

import com.nttdata.recruitmentsystem.dto.ApplicationRequest;
import com.nttdata.recruitmentsystem.employee.dto.EmployeeRole;
import com.nttdata.recruitmentsystem.employee.service.Mapper;
import com.nttdata.recruitmentsystem.entity.ApplicationEntity;
import com.nttdata.recruitmentsystem.repository.ApplicationRepository;
import com.nttdata.recruitmentsystem.dto.Application;
import com.nttdata.recruitmentsystem.employee.entity.EmployeeEntity;
import com.nttdata.recruitmentsystem.candidate.entity.CandidateEntity;
import com.nttdata.recruitmentsystem.candidate.repository.CandidateRepository;
import com.nttdata.recruitmentsystem.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final CandidateRepository candidateRepository;
    private final EmployeeRepository employeeRepository;

    @Transactional
    public Application createApplication(ApplicationRequest applicationRequest) {
        Optional<EmployeeEntity> recruiterEntity = employeeRepository.findById(applicationRequest.getRecruiterId());
        if (!recruiterEntity.isPresent()) {
            throw new IllegalArgumentException("Recruiter " + applicationRequest.getRecruiterId() + " not found!");
        }
        Optional<CandidateEntity> candidateEntity = candidateRepository.findById(applicationRequest.getCandidateId());
        if (!candidateEntity.isPresent()) {
            throw new IllegalArgumentException("Candidate " + applicationRequest.getCandidateId() + " not found!");
        }

        ApplicationEntity applicationEntity = applicationRepository.findByRecruiterAndCandidate(recruiterEntity.get().getId(), candidateEntity.get().getId()).orElse(null);

        if(applicationEntity != null){
            throw new IllegalArgumentException("This application already exists!");
        }

        if(recruiterEntity.get().getRole() == EmployeeRole.RECRUITER) {
            applicationEntity = ApplicationEntity.builder()
                    .recruiter(recruiterEntity.get())
                    .candidate(candidateEntity.get())
                    .creationDate(new Date())
                    .build();

            applicationRepository.save(applicationEntity);
        } else {
            throw new IllegalArgumentException("Can't create application because you are not RECRUITER!");
        }

        Application application = mapEntityToDto(applicationEntity);

        return application;
    }

    public List<Application> findByRecruiterId(Integer recruiterId) {
       List<Application> applications = applicationRepository.findAllByRecruiterId(recruiterId)
               .stream()
               .map(ApplicationService::mapEntityToDto)
               .collect(Collectors.toList());

       return applications;
    }

    public List<Application> findByCandidateId(Integer candidateId) {
        List<Application> applications = applicationRepository.findAllByCandidateId(candidateId)
                .stream()
                .map(ApplicationService::mapEntityToDto)
                .collect(Collectors.toList());

        return applications;
    }

    public static Application mapEntityToDto(ApplicationEntity applicationEntity) {
        return Application.builder()
                .id(applicationEntity.getId())
                .candidate(applicationEntity.getCandidate())
                .recruiter(Mapper.mapEntityToDto(applicationEntity.getRecruiter()))
                .creationDate(applicationEntity.getCreationDate())
                .build();
    }
}
