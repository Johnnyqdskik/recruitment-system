package com.nttdata.recruitmentsystem.controller;

import com.nttdata.recruitmentsystem.dto.ApplicationRequest;
import com.nttdata.recruitmentsystem.dto.Application;
import com.nttdata.recruitmentsystem.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;

    @GetMapping("/recruiters/{id}")
    public List<Application> findAllApplicationsByRecruiterName(@PathVariable("id") Integer recruiterId){
        return applicationService.findByRecruiterId(recruiterId);
    }

    @GetMapping("/candidates/{id}")
    public List<Application> findAllApplicationsByCandidateId(@PathVariable("id") Integer candidateId){
        return applicationService.findByCandidateId(candidateId);
    }

    @PostMapping
    public Application createNewApplication(@RequestBody ApplicationRequest applicationRequest){
        return applicationService.createApplication(applicationRequest);
    }
}
