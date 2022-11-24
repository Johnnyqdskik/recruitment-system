package com.nttdata.recruitmentsystem.controller;

import com.nttdata.recruitmentsystem.dto.Form;
import com.nttdata.recruitmentsystem.dto.FormRequest;
import com.nttdata.recruitmentsystem.repository.FormRepository;
import com.nttdata.recruitmentsystem.service.FormService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/forms")
@RequiredArgsConstructor
public class FormController {

    private final FormService formService;

    @PostMapping
    public ResponseEntity<?> createNewForm(@RequestBody FormRequest formRequest){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/interviewers/{id}")
    public List<Form> findAllFormsByInterviewerId(@PathVariable("id") Integer interviewerId){
        return formService.findFormsByInterviewerId(interviewerId);
    }
}
