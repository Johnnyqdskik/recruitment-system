package com.nttdata.controller;

import com.nttdata.dto.Application;
import com.nttdata.dto.ApplicationRequest;
import com.nttdata.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applications")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;

    @GetMapping("/recruiters/{id}")
    public List<Application> findAllApplicationsByRecruiterName(@PathVariable("id") Integer recruiterId){
        return applicationService.findByRecruiterId(recruiterId);
    }

    @GetMapping("/candidates/{id}")
    public List<Application> findAllApplicationsByCandidateId(@PathVariable("id") Integer candidateId){
        return applicationService.findByCandidateName(candidateId);
    }

    @PostMapping
    public Application createNewApplication(ApplicationRequest applicationRequest){
        return applicationService.createApplication(applicationRequest);
    }
}
