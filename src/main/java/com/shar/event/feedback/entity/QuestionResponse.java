package com.shar.event.feedback.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionResponse {

  @NotEmpty(message = "Question cannot be empty")
  protected String questionText;

  @NotEmpty(message = "QuestionResponse cannot be empty")
  protected String questionResponseText;
}
