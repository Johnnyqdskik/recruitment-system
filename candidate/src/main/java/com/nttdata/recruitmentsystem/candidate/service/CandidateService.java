package com.nttdata.recruitmentsystem.candidate.service;

import com.nttdata.recruitmentsystem.candidate.data.Candidate;
import com.nttdata.recruitmentsystem.candidate.entity.CandidateEntity;
import lombok.extern.slf4j.Slf4j;
import com.nttdata.recruitmentsystem.candidate.mapper.CandidateMapper;
import org.springframework.stereotype.Service;
import com.nttdata.recruitmentsystem.candidate.repository.CandidateRepository;

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
    public void createCandidate(Candidate candidate) {
        Optional<CandidateEntity> existingCandidate = candidateRepository.findByEmail(candidate.getEmail());
        if(existingCandidate.isPresent()){
            log.warn("Candidate with email {} already exists", candidate.getEmail());
            throw new IllegalArgumentException("Candidate with email " + candidate.getEmail() + " already exists");
        }
        candidateRepository.save(CandidateMapper.mapDtoToEntity(candidate));
    }
    public List<Candidate> findAllCandidates(){
        Iterable<CandidateEntity> candidateEntities = candidateRepository.findAll();
        List<Candidate> result = StreamSupport.stream(candidateEntities.spliterator(), false)
                .map(CandidateMapper::mapEntityToDto)
                .collect(Collectors.toList());
        return result;
    }

}
