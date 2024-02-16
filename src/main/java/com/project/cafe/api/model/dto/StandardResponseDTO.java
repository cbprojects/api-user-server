package com.project.cafe.api.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StandardResponseDTO {

  private boolean success;
  private ErrorDTO error;
  private Object data;

  public StandardResponseDTO(Object data) {
    this.data = data;
  }
}
