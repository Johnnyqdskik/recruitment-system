package mapper;

import data.Candidate;
import entity.CandidateEntity;

public class CandidateMapper {

    public static Candidate mapEntityToDto(CandidateEntity entity){
        return Candidate.builder()
                .candidateFirstName(entity.getCandidateFirstName())
                .candidateLastName(entity.getCandidateLastName())
                .ssn(entity.getSsn())
                .build();
    }

    public static CandidateEntity mapDtoToEntity(Candidate c) {
        return CandidateEntity.builder()
                .candidateFirstName(c.getCandidateFirstName())
                .candidateLastName(c.getCandidateLastName())
                .ssn(c.getSsn())
                .build();

    }
}
