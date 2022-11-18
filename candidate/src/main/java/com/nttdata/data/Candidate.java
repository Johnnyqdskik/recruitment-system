package com.nttdata.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.GeneratedValue;

@Data
@Builder
@AllArgsConstructor
public class Candidate {


    private int id;
    private String candidateName;
    private String email;




}
