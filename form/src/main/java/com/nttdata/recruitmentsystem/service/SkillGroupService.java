package com.nttdata.recruitmentsystem.service;

import com.nttdata.recruitmentsystem.dto.SkillGroup;
import com.nttdata.recruitmentsystem.dto.SkillGroupRequest;
import com.nttdata.recruitmentsystem.entity.SkillGroupEntity;
import com.nttdata.recruitmentsystem.repository.SkillGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SkillGroupService {

    private final SkillGroupRepository skillGroupRepository;

    public void createSkillGroup(SkillGroupRequest skillGroupRequest){
        Optional<SkillGroupEntity> existingSkillGroup = skillGroupRepository.findByName(skillGroupRequest.getSkillName());

        if(existingSkillGroup.isPresent()){
            throw new IllegalArgumentException("This skill group already exists");
        }
        skillGroupRepository.save(mapDtoToEntity(skillGroupRequest));
    }

    private SkillGroupEntity mapDtoToEntity(SkillGroupRequest skillGroupRequest){
        return SkillGroupEntity.builder()
                .skillName(skillGroupRequest.getSkillName())
                .build();
    }
}
