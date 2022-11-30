package com.nttdata.recruitmentsystem.service;

import com.nttdata.recruitmentsystem.dto.Form;
import com.nttdata.recruitmentsystem.dto.FormCreateRequest;
import com.nttdata.recruitmentsystem.employee.entity.EmployeeEntity;
import com.nttdata.recruitmentsystem.employee.repository.EmployeeRepository;
import com.nttdata.recruitmentsystem.employee.service.EmployeeMapper;
import com.nttdata.recruitmentsystem.entity.ApplicationEntity;
import com.nttdata.recruitmentsystem.entity.SkillGroupEntity;
import com.nttdata.recruitmentsystem.entity.TopicEntity;
import com.nttdata.recruitmentsystem.mapper.ApplicationMapper;
import com.nttdata.recruitmentsystem.repository.ApplicationRepository;
import com.nttdata.recruitmentsystem.repository.FormRepository;
import com.nttdata.recruitmentsystem.entity.FormEntity;
import com.nttdata.recruitmentsystem.repository.SkillGroupRepository;
import com.nttdata.recruitmentsystem.repository.TopicRepository;
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

    private final SkillGroupRepository skillGroupRepository;

    private final TopicRepository topicRepository;

    @Transactional
    public void createForm(FormCreateRequest formCreateRequest){
        Optional<EmployeeEntity> interviewerEntity = employeeRepository.findById(formCreateRequest.getInterviewerId());
        if (!interviewerEntity.isPresent()) {
            throw new IllegalArgumentException("Interviewer " + formCreateRequest.getInterviewerId() + " not found!");
        }
        Optional<ApplicationEntity> applicationEntity = applicationRepository.findById(formCreateRequest.getApplicationId());
        if (!applicationEntity.isPresent()) {
            throw new IllegalArgumentException("Application " + formCreateRequest.getApplicationId() + " not found!");
        }
        Optional<FormTemplateEntity> formTemplateEntity = formTemplateRepository.findById(formCreateRequest.getTemplateId());
        if(!formTemplateEntity.isPresent()){
            throw new IllegalArgumentException("Template " + formCreateRequest.getTemplateId() + " not found!");
        }

        FormEntity formEntity = formRepository.findByInterviewerAndApplication(interviewerEntity.get().getId(), applicationEntity.get().getId()).orElse(null);

        if(formEntity != null){
            throw new IllegalArgumentException("This form already exists!");
        }

        Set<SkillGroupEntity> skillGroupEntitySet = formTemplateEntity.get().getSkillGroupTemplateEntities().stream()
                .map(o -> skillTempToSkill(o))
                .collect(Collectors.toSet());

//        Set<SkillGroupEntity> finalSetofSkills = skillGroupEntitySet.stream()
//                .peek(o -> {
//                    Set<TopicTemplateEntity> topics = formTemplateEntity.get().getTopicTemplateEntities();
//                    o.setTopics(topics.stream().filter(t -> t.getSkillGroupTemplateEntity().getId() == o.getId())
//                            .map(topic -> topicEntityToTopic(topic)).collect(Collectors.toSet()));
//                }).collect(Collectors.toSet());

        formEntity = FormEntity.builder()
                .interviewer(interviewerEntity.get())
                .application(applicationEntity.get())
                .name(formTemplateEntity.get().getFormTemplateName())
                .build();

        formRepository.save(formEntity);

        for (SkillGroupEntity s:skillGroupEntitySet) {
            s.setForm(formEntity);
        }

        skillGroupRepository.saveAll(skillGroupEntitySet);

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
                .form(null)
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
                .interviewer(EmployeeMapper.mapEntityToDto(formEntity.getInterviewer()))
                .averageGrade(formEntity.getAverageGrade())
                .interviewerComment(formEntity.getComment())
                .name(formEntity.getName())
                .build();
    }
}
