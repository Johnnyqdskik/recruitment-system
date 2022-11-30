package com.nttdata.recruitmentsystem.mapper;

import com.nttdata.recruitmentsystem.dto.FormHeader;
import com.nttdata.recruitmentsystem.employee.service.EmployeeMapper;
import com.nttdata.recruitmentsystem.entity.FormEntity;

public class FormMapper {

    public static FormHeader mapToDto(FormEntity formEntity) {
        return FormHeader.builder()
                .id(formEntity.getId())
                .name(formEntity.getName())
                .interviewer(EmployeeMapper.mapEntityToDto(formEntity.getInterviewer()))
                .interviewerComment(formEntity.getComment())
                .build();
    }
}
