package com.shar.event.feedback.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class FormResponseDTO {

  protected String formResponseId;

  protected String formId;

  protected String formTitle;

  protected String formDescription;

  protected Set<@NotEmpty QuestionResponseDTO> questionResponses;
}
