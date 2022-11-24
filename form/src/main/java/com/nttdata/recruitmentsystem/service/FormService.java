package com.nttdata.recruitmentsystem.service;

import com.nttdata.recruitmentsystem.dto.Form;
import com.nttdata.recruitmentsystem.dto.FormRequest;
import com.nttdata.recruitmentsystem.employee.entity.EmployeeEntity;
import com.nttdata.recruitmentsystem.employee.repository.EmployeeRepository;
import com.nttdata.recruitmentsystem.employee.service.Mapper;
import com.nttdata.recruitmentsystem.entity.ApplicationEntity;
import com.nttdata.recruitmentsystem.entity.SkillGroupEntity;
import com.nttdata.recruitmentsystem.entity.TopicEntity;
import com.nttdata.recruitmentsystem.repository.ApplicationRepository;
import com.nttdata.recruitmentsystem.repository.FormRepository;
import com.nttdata.recruitmentsystem.entity.FormEntity;
import com.nttdata.recruitmentsystem.template.entity.FormTemplateEntity;
import com.nttdata.recruitmentsystem.template.entity.SkillGroupTemplateEntity;
import com.nttdata.recruitmentsystem.template.entity.TopicTemplateEntity;
import com.nttdata.recruitmentsystem.template.repository.FormTemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FormService {

    private final FormRepository formRepository;
    private final EmployeeRepository employeeRepository;
    private final ApplicationRepository applicationRepository;
    private final FormTemplateRepository formTemplateRepository;


    @Transactional
    public void createForm(FormRequest formRequest){
        Optional<EmployeeEntity> interviewerEntity = employeeRepository.findById(formRequest.getInterviewerId());
        if (!interviewerEntity.isPresent()) {
            throw new IllegalArgumentException("Interviewer " + formRequest.getInterviewerId() + " not found!");
        }
        Optional<ApplicationEntity> applicationEntity = applicationRepository.findById(formRequest.getApplicationId());
        if (!applicationEntity.isPresent()) {
            throw new IllegalArgumentException("Application " + formRequest.getApplicationId() + " not found!");
        }
        Optional<FormTemplateEntity> formTemplateEntity = formTemplateRepository.findById(formRequest.getTemplateId());
        if(!formTemplateEntity.isPresent()){
            throw new IllegalArgumentException("Template " + formRequest.getTemplateId() + " not found!");
        }

        FormEntity formEntity = formRepository.findByInterviewerAndApplication(interviewerEntity.get().getId(), applicationEntity.get().getId()).orElse(null);

        if(formEntity != null){
            throw new IllegalArgumentException("This form already exists!");
        }

        Set<SkillGroupEntity> skillGroupEntitySet = formTemplateEntity.get().getSkillGroupTemplateEntities().stream()
                .map(o -> skillTempToSkill(o))
                .collect(Collectors.toSet());

        Set<SkillGroupEntity> finalSetofSkills = skillGroupEntitySet.stream()
                .peek(o -> {
                    Set<TopicTemplateEntity> topics = formTemplateEntity.get().getTopicTemplateEntities();
                    o.setTopics(topics.stream().filter(t -> t.getSkillGroupTemplateEntity().getId() == o.getId())
                            .map(topic -> topicEntityToTopic(topic)).collect(Collectors.toSet()));
                }).collect(Collectors.toSet());

        formEntity = FormEntity.builder()
                .interviewer(interviewerEntity.get())
                .application(applicationEntity.get())
                .skillGroups(skillGroupEntitySet)
                .build();

        formRepository.save(formEntity);
    }

    private TopicEntity topicEntityToTopic(TopicTemplateEntity topic) {

        return TopicEntity.builder()
                .topicName(topic.getTopicTemplateName())
                .grade(0)
                .comment("")
                .mandatory(true)
                .build();

    }

    private SkillGroupEntity skillTempToSkill(SkillGroupTemplateEntity o) {

        return SkillGroupEntity.builder()
                .skillName(o.getSkillGroupName())
                .averageGrade(0)
                .build();

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
                .application(ApplicationMapper.mapEntityToDto(formEntity.getApplication()))
                .interviewer(Mapper.mapEntityToDto(formEntity.getInterviewer()))
                .averageGrade(formEntity.getAverageGrade())
                .comment(formEntity.getComment())
                .name(formEntity.getName())
                .build();
    }
}
