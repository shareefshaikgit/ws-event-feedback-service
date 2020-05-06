package com.shar.event.feedback.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class FormDTO {

  protected String formId;

  @NotEmpty(message = "Form title cannot be empty")
  protected String formTitle;

  @NotEmpty(message = "Form description cannot be empty")
  protected String formDescription;

  @Valid
  @NotEmpty(message = "Questions cannot be empty")
  protected Set<@NotNull QuestionDTO> questions;
}
