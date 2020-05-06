package com.shar.event.feedback.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
  @JsonSubTypes.Type(value = MultipleChoiceQuestionDTO.class, name = "multipleChoiceQuestion"),
  @JsonSubTypes.Type(value = ParagraphQuestionDTO.class, name = "paragraphQuestion"),
  @JsonSubTypes.Type(value = ShortAnswerQuestionDTO.class, name = "shortAnswerQuestion")
})
public abstract class QuestionDTO {

  @NotEmpty(message = "Question text cannot be empty")
  protected String questionText;
}
