package com.nttdata.recruitmentsystem.service;

import com.nttdata.recruitmentsystem.dto.SkillGroupRequest;
import com.nttdata.recruitmentsystem.entity.FormEntity;
import com.nttdata.recruitmentsystem.entity.SkillGroupEntity;
import com.nttdata.recruitmentsystem.repository.SkillGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SkillGroupService {

    private final SkillGroupRepository skillGroupRepository;

    public void createSkillGroup(SkillGroupRequest skillGroupRequest){
        Optional<SkillGroupEntity> skillGroupEntity = skillGroupRepository.findByGroupName(skillGroupRequest.getSkillName());
        if(skillGroupEntity.isPresent()){
            throw new IllegalArgumentException("Skill group " + skillGroupRequest.getSkillName() + " already exists");
        }

        List<FormEntity> forms = skillGroupRepository.findByFormName(skillGroupRequest.getFormName());
        if(forms.isEmpty()){
            throw new IllegalArgumentException("Form " + skillGroupRequest.getFormName() + " doesn't exists");
        }

        SkillGroupEntity skillGroupEntity1 = skillGroupRepository.findBySkillNameAndForm(skillGroupEntity.get().getSkillName(),
                forms.stream().findFirst().get().getId())
                .orElse(null);

        if(skillGroupEntity1 != null){
            throw new IllegalArgumentException("This skill group already exists!");
        }

        skillGroupEntity1 = SkillGroupEntity.builder()
                .skillName(skillGroupEntity.get().getSkillName())
                .form(forms.stream().findFirst().get())
                .build();

        skillGroupRepository.save(skillGroupEntity1);
    }

}
