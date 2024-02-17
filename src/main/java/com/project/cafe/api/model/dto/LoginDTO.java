package com.project.cafe.api.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private String mail;
  private String password;
}
