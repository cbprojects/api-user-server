package com.project.cafe.api.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseDTO {

  private Long id;
  private boolean active;
  private LocalDateTime createDate;
  private String createUser;
  private LocalDateTime updateDate;
  private String updateUser;
}
