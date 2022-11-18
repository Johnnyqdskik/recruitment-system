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

    @GetMapping("/{recruiterName}")
    public List<Application> findAllApplicationsByRecruiterName(@PathVariable("recruiterName") String recruiterName){
        return findAllApplicationsByRecruiterName(recruiterName);
    }

    @GetMapping("/{candidateName}")
    public List<Application> findAllApplicationsByCandidateName(@PathVariable("candidateName") String candidateName){
        return findAllApplicationsByCandidateName(candidateName);
    }

    @PostMapping("/{create}")
    public Application createNewApplication(ApplicationRequest applicationRequest){
        return applicationService.createApplication(applicationRequest);
    }
}
