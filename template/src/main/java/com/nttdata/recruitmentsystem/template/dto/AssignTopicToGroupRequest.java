package com.nttdata.recruitmentsystem.template.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AssignTopicToGroupRequest {
    private Integer groupId;
    private Integer topicId;
}