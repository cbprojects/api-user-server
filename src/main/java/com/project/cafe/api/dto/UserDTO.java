package com.project.cafe.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO extends BaseDTO {

  private String name;
  private String lastName;
  private String mail;
  private String password;
  private boolean receiveNewsletter;
}
