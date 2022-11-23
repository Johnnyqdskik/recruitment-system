package com.nttdata.recruitmentsystem.service;

import com.nttdata.recruitmentsystem.dto.Form;
import com.nttdata.recruitmentsystem.dto.FormRequest;
import com.nttdata.recruitmentsystem.employee.entity.EmployeeEntity;
import com.nttdata.recruitmentsystem.employee.repository.EmployeeRepository;
import com.nttdata.recruitmentsystem.entity.ApplicationEntity;
import com.nttdata.recruitmentsystem.repository.ApplicationRepository;
import com.nttdata.recruitmentsystem.repository.FormRepository;
import com.nttdata.recruitmentsystem.entity.FormEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FormService {

    private final FormRepository formRepository;
    private final EmployeeRepository employeeRepository;
    private final ApplicationRepository applicationRepository;


    @Transactional
    public Form createForm(FormRequest formRequest){
        Optional<EmployeeEntity> interviewerEntity = employeeRepository.findById(formRequest.getInterviewerId());
        if (!interviewerEntity.isPresent()) {
            throw new IllegalArgumentException("Interviewer " + formRequest.getInterviewerId() + " not found!");
        }
        Optional<ApplicationEntity> applicationEntity = applicationRepository.findById(formRequest.getApplicationId());
        if (!applicationEntity.isPresent()) {
            throw new IllegalArgumentException("Application " + formRequest.getApplicationId() + " not found!");
        }

        FormEntity formEntity = formRepository.findByInterviewerAndApplication(interviewerEntity.get().getId(), applicationEntity.get().getId()).orElse(null);

        if(formEntity != null){
            throw new IllegalArgumentException("This form already exists!");
        }

        formEntity = FormEntity.builder()
                .interviewer(interviewerEntity.get())
                .application(applicationEntity.get())
                .name(formRequest.getFormName())
                .build();

        formRepository.save(formEntity);

        Form forms = mapEntityToDto(formEntity);

        return forms;
    }

    public List<Form> findFormsByInterviewerId(Integer interviewerId){
        List<Form> forms = formRepository.findByInterviewerId(interviewerId)
                .stream()
                .map(FormService::mapEntityToDto)
                .collect(Collectors.toList());

        return forms;
    }

    public static Form mapEntityToDto(FormEntity formEntity){
        return Form.builder()
                .application(formEntity.getApplication())
                .interviewer(formEntity.getInterviewer())
                .averageGrade(formEntity.getAverageGrade())
                .comment(formEntity.getComment())
                .name(formEntity.getName())
                .build();
    }
}
