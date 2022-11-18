package controller;

import data.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;
import service.CandidateService;

import java.util.List;

@RestController
@RequestMapping
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
    public ResponseEntity<?> createCandidate (@RequestBody Candidate candidate) {
        candidateService.createCandidate(candidate);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> deleteCandidate (@RequestBody Candidate candidate){
        candidateService.deleteCandidate(candidate);
        return new ResponseEntity<>(HttpStatus.OK);
        }
    }

