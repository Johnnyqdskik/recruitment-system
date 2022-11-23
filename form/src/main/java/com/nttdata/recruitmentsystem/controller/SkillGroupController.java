package com.nttdata.recruitmentsystem.controller;

import com.nttdata.recruitmentsystem.dto.SkillGroup;
import com.nttdata.recruitmentsystem.dto.SkillGroupRequest;
import com.nttdata.recruitmentsystem.service.SkillGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/skillGroups")
@RequiredArgsConstructor
public class SkillGroupController {

    private final SkillGroupService skillGroupService;

    @PostMapping
    private ResponseEntity<?> createSkillGroup(@RequestBody SkillGroupRequest skillGroupRequest){
        skillGroupService.createSkillGroup(skillGroupRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
