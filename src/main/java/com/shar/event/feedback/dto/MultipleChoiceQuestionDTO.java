package com.shar.event.feedback.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MultipleChoiceQuestionDTO extends QuestionDTO {

  protected Set<@NotEmpty OptionDTO> options;
}
