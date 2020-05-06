package com.shar.event.feedback.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Option {

  @NotEmpty(message = "Option cannot be empty")
  protected String optionText;
}
