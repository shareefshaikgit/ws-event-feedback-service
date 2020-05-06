package com.shar.event.feedback.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Document("Form")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Form {

  @Id protected String formId;

  @NotEmpty(message = "EventId cannot be empty")
  protected String eventId;

  @NotEmpty(message = "Form title cannot be empty")
  protected String formTitle;

  @NotEmpty(message = "Form description cannot be empty")
  protected String formDescription;

  @Valid
  @NotEmpty(message = "Questions cannot be empty")
  protected Set<@NotNull Question> questions;
}
