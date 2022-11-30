package com.nttdata.recruitmentsystem.controller;

import com.nttdata.recruitmentsystem.dto.ApplicationRequest;
import com.nttdata.recruitmentsystem.dto.ApplicationResponse;
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
    public List<ApplicationResponse> findAllApplicationsByRecruiterName(@PathVariable("id") Integer recruiterId){
        return applicationService.findByRecruiterId(recruiterId);
    }

    @PostMapping
    public ApplicationResponse createNewApplication(@RequestBody ApplicationRequest applicationRequest){
        return applicationService.createApplication(applicationRequest);
    }
}
