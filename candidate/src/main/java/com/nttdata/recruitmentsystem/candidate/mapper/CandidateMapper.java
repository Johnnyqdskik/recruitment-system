package com.nttdata.recruitmentsystem.candidate.mapper;

import com.nttdata.recruitmentsystem.candidate.data.Candidate;
import com.nttdata.recruitmentsystem.candidate.data.CandidateRequest;
import com.nttdata.recruitmentsystem.candidate.entity.CandidateEntity;

public class CandidateMapper {

    public static Candidate mapEntityToDto(CandidateEntity entity){
        return Candidate.builder()
                .id(entity.getId())
                .candidateName(entity.getCandidateName())
                .email(entity.getEmail())
                .phoneNumber(entity.getPhoneNumber())
                .build();
    }

    public static CandidateEntity mapDtoToEntity(CandidateRequest c) {
        return CandidateEntity.builder()
                .candidateName(c.getCandidateName())
                .email(c.getEmail())
                .phoneNumber(c.getPhoneNumber())
                .build();

    }
}
