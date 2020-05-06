package com.shar.event.feedback.entity;

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
  @JsonSubTypes.Type(value = MultipleChoiceQuestion.class, name = "multipleChoiceQuestion"),
  @JsonSubTypes.Type(value = ParagraphQuestion.class, name = "paragraphQuestion"),
  @JsonSubTypes.Type(value = ShortAnswerQuestion.class, name = "shortAnswerQuestion")
})
public abstract class Question {

  @NotEmpty(message = "Question text cannot be empty")
  protected String questionText;
}
