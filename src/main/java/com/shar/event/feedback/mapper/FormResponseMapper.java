package com.shar.event.feedback.mapper;

import com.shar.event.feedback.dto.FormResponseDTO;
import com.shar.event.feedback.dto.QuestionResponseDTO;
import com.shar.event.feedback.entity.FormResponse;
import com.shar.event.feedback.entity.QuestionResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FormResponseMapper {

    FormResponse mapToFormResponse(FormResponseDTO formResponseDTO);

    QuestionResponse mapToQuestionResponse(QuestionResponseDTO questionResponseDTO);

    FormResponseDTO mapToFormResponseDTO(FormResponse formResponse);

    QuestionResponseDTO mapToQuestionResponseDTO(QuestionResponse questionResponse);
}
