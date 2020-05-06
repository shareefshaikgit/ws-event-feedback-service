package com.shar.event.feedback.controller;

import com.shar.event.feedback.dto.FormDTO;
import com.shar.event.feedback.dto.FormResponseDTO;
import com.shar.event.feedback.service.FormService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.annotation.security.RolesAllowed;

@RestController
@AllArgsConstructor
@RequestMapping("/eventfeedback")
public class FormController {

  private final FormService formService;

  @PostMapping("/form")
  @RolesAllowed("PERMISSION_CREATEFORM")
  public Mono<FormDTO> createForm(@RequestBody FormDTO formDTO) {
    return formService.createForm(formDTO);
  }

  @PostMapping("/formresponse")
  @RolesAllowed("ROLE_NEWUSER")
  public Mono<FormResponseDTO> createFormResponse(@RequestBody FormResponseDTO formResponseDTO){
    return formService.createFormResponse(formResponseDTO);
  }
}
