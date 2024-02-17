package com.project.cafe.api.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StandardResponseDTO {

  private boolean success;
  private ErrorDTO error;
  private Object data;

  public StandardResponseDTO(Object data) {
    this.success = true;
    this.data = data;
  }
}
