package com.shar.event.feedback.service;

import com.shar.event.feedback.dto.*;
import com.shar.event.feedback.entity.*;
import com.shar.event.feedback.mapper.FormMapper;
import com.shar.event.feedback.mapper.FormResponseMapper;
import com.shar.event.feedback.repository.FormRepository;
import com.shar.event.feedback.repository.FormResponseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FormService {

  private final FormRepository formRepository;
  private final FormResponseRepository formResponseRepository;
  private final FormMapper formMapper;
  private final FormResponseMapper formResponseMapper;

  public Mono<FormDTO> createForm(FormDTO formDTO) {
    Form form = formMapper.mapToForm(formDTO);
    Set<Question> questions = mapQuestions(formDTO.getQuestions());
    form.setQuestions(questions);
    Mono<Form> formMono = formRepository.save(form);
    Mono<FormDTO> formDTOMono = formMono.map(this::mapToFormDTO);
    return formDTOMono;
  }

  private FormDTO mapToFormDTO(Form form) {
    FormDTO formDTO = formMapper.mapToFormDTO(form);
    Set<QuestionDTO> questionDTOS =
        form.getQuestions().stream().map(this::mapToQuestionDTO).collect(Collectors.toSet());
    formDTO.setQuestions(questionDTOS);
    return formDTO;
  }

  private Set<Question> mapQuestions(Set<QuestionDTO> questionDTOList) {
    return questionDTOList.stream().map(this::mapToQuestion).collect(Collectors.toSet());
  }

  private Set<QuestionDTO> mapQuestionDTOList(Set<Question> questionList) {
    return questionList.stream().map(this::mapToQuestionDTO).collect(Collectors.toSet());
  }

  private QuestionDTO mapToQuestionDTO(Question question) {
    if (question instanceof ParagraphQuestion) {
      return formMapper.mapToParagraphQuestionDTO((ParagraphQuestion) question);
    } else if (question instanceof ShortAnswerQuestion) {
      return formMapper.mapToShortAnswerQuestionDTO((ShortAnswerQuestion) question);
    } else if (question instanceof MultipleChoiceQuestion) {
      return formMapper.mapToMultipleChoiceQuestionDTO((MultipleChoiceQuestion) question);
    } else {
      return null;
    }
  }

  private Question mapToQuestion(QuestionDTO questionDTO) {
    if (questionDTO instanceof ParagraphQuestionDTO) {
      return formMapper.mapToParagraphQuestion((ParagraphQuestionDTO) questionDTO);
    } else if (questionDTO instanceof ShortAnswerQuestionDTO) {
      return formMapper.mapToShortAnswerQuestion((ShortAnswerQuestionDTO) questionDTO);
    } else if (questionDTO instanceof MultipleChoiceQuestionDTO) {
      return formMapper.mapToMultipleChoiceQuestion((MultipleChoiceQuestionDTO) questionDTO);
    } else {
      return null;
    }
  }

  public Mono<FormResponseDTO> createFormResponse(FormResponseDTO formResponseDTO) {
    FormResponse formResponse = formResponseMapper.mapToFormResponse(formResponseDTO);
    Mono<FormResponse> formResponseMono = formResponseRepository.save(formResponse);
    return formResponseMono.map(formResponseMapper::mapToFormResponseDTO);
  }
}
