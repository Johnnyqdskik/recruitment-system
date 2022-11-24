package com.nttdata.recruitmentsystem.candidate.service;

import com.nttdata.recruitmentsystem.candidate.data.Candidate;
import com.nttdata.recruitmentsystem.candidate.data.CandidateRequest;
import com.nttdata.recruitmentsystem.candidate.entity.CandidateEntity;
import com.nttdata.recruitmentsystem.exceptionHandler.userExceptions.UsernameDuplicateException;
import lombok.extern.slf4j.Slf4j;
import com.nttdata.recruitmentsystem.candidate.mapper.CandidateMapper;
import org.springframework.stereotype.Service;
import com.nttdata.recruitmentsystem.candidate.repository.CandidateRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Slf4j
public class CandidateService {

    private final CandidateRepository candidateRepository;

    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;


    }
    public void createCandidate(CandidateRequest candidateRequest) {
        Optional<CandidateEntity> existingCandidate = candidateRepository.findByEmail(candidateRequest.getEmail());
        if(!existingCandidate.isEmpty()){
            throw new UsernameDuplicateException(candidateRequest.getEmail());
        }
        candidateRepository.save(CandidateMapper.mapDtoToEntity(candidateRequest));
    }
    public List<Candidate> findAllCandidates(){
        Iterable<CandidateEntity> candidateEntities = candidateRepository.findAll();
        List<Candidate> result = StreamSupport.stream(candidateEntities.spliterator(), false)
                .map(CandidateMapper::mapEntityToDto)
                .collect(Collectors.toList());
        return result;
    }

}
