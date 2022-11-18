package com.nttdata.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Application {

    private Candidate candidate;
    private User recruiter;
    private Date creationDate;
}
