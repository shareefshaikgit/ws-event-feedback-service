package com.shar.event.feedback.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MultipleChoiceQuestion extends Question {

  protected Set<@NotEmpty Option> options;
}
