package com.shar.event.feedback.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class FormResponse {

  @Id protected String formResponseId;

  protected String formId;

  protected String formTitle;

  protected String formDescription;

  protected Set<@NotEmpty QuestionResponse> questionResponses;
}
