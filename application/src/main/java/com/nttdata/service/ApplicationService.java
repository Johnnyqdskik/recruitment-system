package com.nttdata.service;

import com.nttdata.dto.Application;
import com.nttdata.dto.ApplicationRequest;
import com.nttdata.entity.ApplicationEntity;
import com.nttdata.repository.ApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApplicationService {

    private final ApplicationRepository applicationRepository;

    @Transactional
    public Application createApplication(ApplicationRequest applicationRequest){
        UserEntity recruiterEntity = userRepository.findByUserName(applicationRequest.getRecruiterName());
        if (recruiterEntity == null) {
            throw new IllegalArgumentException("Recruiter " + applicationRequest.getRecruiterName() + " not found!");
        }
        CandidateEntity candidateEntity = candidateRepository.findByCandidateName(applicationRequest.getCandidateName());
        if (candidateEntity == null) {
            throw new IllegalArgumentException("Candidate " + applicationRequest.getCandidateName() + " not found!");
        }

        ApplicationEntity applicationEntity = applicationRepository.findByRecruiterAndCandidate(recruiterEntity, candidateEntity).orElse(null);

        if(applicationEntity != null){
            throw new IllegalArgumentException("This application already exists!");
        }

        applicationEntity = ApplicationEntity.builder()
                .recruiter(recruiterEntity)
                .candidate(candidateEntity)
                .creationDate(new Date())
                .build();

        Application application = mapEntityToDto(applicationEntity);

        return application;
    }

    private List<Application> findByRecruiterName(String recruiterName){
       List<Application> applications = applicationRepository.findAllByRecruiterName(recruiterName)
               .stream()
               .map(ApplicationService::mapEntityToDto)
               .collect(Collectors.toList());

       return applications;
    }

    private List<Application> findByCandidateName(String candidateName){
        List<Application> applications = applicationRepository.findAllByCandidateName(candidateName)
                .stream()
                .map(ApplicationService::mapEntityToDto)
                .collect(Collectors.toList());

        return applications;
    }

    public static Application mapEntityToDto(ApplicationEntity applicationEntity){
        return Application.builder()
                .candidate(applicationEntity.getCandidate())
                .recruiter(applicationEntity.getRecruiter())
                .creationDate(applicationEntity.getCreationDate())
                .build();
    }
}
