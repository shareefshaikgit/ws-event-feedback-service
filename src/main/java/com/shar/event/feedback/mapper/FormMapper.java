package com.shar.event.feedback.mapper;

import com.shar.event.feedback.dto.FormDTO;
import com.shar.event.feedback.dto.MultipleChoiceQuestionDTO;
import com.shar.event.feedback.dto.ParagraphQuestionDTO;
import com.shar.event.feedback.dto.ShortAnswerQuestionDTO;
import com.shar.event.feedback.entity.Form;
import com.shar.event.feedback.entity.MultipleChoiceQuestion;
import com.shar.event.feedback.entity.ParagraphQuestion;
import com.shar.event.feedback.entity.ShortAnswerQuestion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FormMapper {
  
  @Mapping(target = "questions", source = "questions", ignore = true)
  Form mapToForm(FormDTO formDTO);

  @Mapping(target = "questions", source = "questions", ignore = true)
  FormDTO mapToFormDTO(Form form);

  ParagraphQuestion mapToParagraphQuestion(ParagraphQuestionDTO paragraphQuestionDTO);

  ParagraphQuestionDTO mapToParagraphQuestionDTO(ParagraphQuestion paragraphQuestion);

  ShortAnswerQuestion mapToShortAnswerQuestion(ShortAnswerQuestionDTO shortAnswerQuestionDTO);

  ShortAnswerQuestionDTO mapToShortAnswerQuestionDTO(ShortAnswerQuestion shortAnswerQuestion);

  MultipleChoiceQuestion mapToMultipleChoiceQuestion(
      MultipleChoiceQuestionDTO multipleChoiceQuestionDTO);

  MultipleChoiceQuestionDTO mapToMultipleChoiceQuestionDTO(
      MultipleChoiceQuestion multipleChoiceQuestion);
}
