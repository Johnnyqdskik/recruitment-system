package com.nttdata.recruitmentsystem.candidate.controller;

import com.nttdata.recruitmentsystem.candidate.service.CandidateService;
import com.nttdata.recruitmentsystem.candidate.data.Candidate;
import com.nttdata.recruitmentsystem.candidate.data.CandidateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/candidates")
public class CandidateController {

    private final CandidateService candidateService;

    @Autowired
    public CandidateController(CandidateService candidateService){
        this.candidateService = candidateService;
    }

    @GetMapping
    public List<Candidate> getAll(){
        return candidateService.findAllCandidates();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('RECRUITER')")
    public ResponseEntity<?> createCandidate (@RequestBody @Valid CandidateRequest candidateRequest) {
        candidateService.createCandidate(candidateRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

