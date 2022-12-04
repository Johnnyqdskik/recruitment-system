package com.nttdata.recruitmentsystem.service;

import com.nttdata.recruitmentsystem.candidate.entity.CandidateEntity;
import com.nttdata.recruitmentsystem.candidate.mapper.CandidateMapper;
import com.nttdata.recruitmentsystem.candidate.repository.CandidateRepository;
import com.nttdata.recruitmentsystem.dto.ApplicationRequest;
import com.nttdata.recruitmentsystem.dto.ApplicationResponse;
import com.nttdata.recruitmentsystem.employee.dto.EmployeeRole;
import com.nttdata.recruitmentsystem.employee.entity.EmployeeEntity;
import com.nttdata.recruitmentsystem.employee.repository.EmployeeRepository;
import com.nttdata.recruitmentsystem.employee.service.EmployeeMapper;
import com.nttdata.recruitmentsystem.entity.ApplicationEntity;
import com.nttdata.recruitmentsystem.entity.FormEntity;
import com.nttdata.recruitmentsystem.mapper.FormMapper;
import com.nttdata.recruitmentsystem.repository.ApplicationRepository;
import com.nttdata.recruitmentsystem.repository.FormRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final CandidateRepository candidateRepository;
    private final EmployeeRepository employeeRepository;
    private final FormRepository formRepository;

    @Transactional
    public ApplicationResponse createApplication(ApplicationRequest applicationRequest) {
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

        if (recruiterEntity.get().getRole() == EmployeeRole.RECRUITER) {
            applicationEntity = ApplicationEntity.builder()
                    .recruiter(recruiterEntity.get())
                    .candidate(candidateEntity.get())
                    .creationDate(new Date())
                    .build();

            applicationRepository.save(applicationEntity);
        } else {
            throw new IllegalArgumentException("Applications can only be assigned to RECRUITER role.");
        }

        ApplicationResponse applicationResponse = mapEntityToDto(applicationEntity, null);

        return applicationResponse;
    }

    public List<ApplicationResponse> findByRecruiterId(Integer recruiterId) {
       List<ApplicationEntity> applicationEntities = applicationRepository.findAllByRecruiterId(recruiterId);
       Map<ApplicationEntity, FormEntity> formsByApplicationMap = formRepository.findAllByApplicationIn(applicationEntities)
               .stream()
               .collect(Collectors.toMap(FormEntity::getApplication, Function.identity()));

       return applicationEntities
               .stream()
               .map(application -> {
                   FormEntity form = formsByApplicationMap.get(application);
                   return mapEntityToDto(application, form);
               }).collect(Collectors.toList());
    }


    public static ApplicationResponse mapEntityToDto(ApplicationEntity applicationEntity, FormEntity formEntity) {
        return ApplicationResponse.builder()
                .id(applicationEntity.getId())
                .candidate(CandidateMapper.mapEntityToDto(applicationEntity.getCandidate()))
                .recruiter(EmployeeMapper.mapEntityToDto(applicationEntity.getRecruiter()))
                .recruiterComment(applicationEntity.getRecruiterComment())
                .form(formEntity == null ? null : FormMapper.mapToDto(formEntity))
                .creationDate(applicationEntity.getCreationDate())
                .build();
    }
}
