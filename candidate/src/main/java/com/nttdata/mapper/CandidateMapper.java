package com.nttdata.mapper;

import com.nttdata.data.Candidate;
import com.nttdata.entity.CandidateEntity;

public class CandidateMapper {

    public static Candidate mapEntityToDto(CandidateEntity entity){
        return Candidate.builder()
                .candidateName(entity.getCandidateName())
                .email(entity.getCandidateEmail())
                .build();
    }

    public static CandidateEntity mapDtoToEntity(Candidate c) {
        return CandidateEntity.builder()
                .candidateName(c.getCandidateName())
                .candidateEmail(c.getEmail())
                .build();

    }
}
