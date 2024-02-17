package com.project.cafe.api.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, length = 19)
  private Long id;

  @Column(name = "active", nullable = false)
  private boolean active;

  @Column(name = "create_date", nullable = false)
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime createDate;

  @Column(name = "create_user", nullable = false)
  private String createUser;

  @Column(name = "update_date", nullable = false)
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime updateDate;

  @Column(name = "update_user", nullable = false)
  private String updateUser;
}
