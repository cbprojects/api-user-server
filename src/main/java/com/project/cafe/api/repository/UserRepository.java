package com.project.cafe.api.repository;

import com.project.cafe.api.model.UserEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
  Optional<UserEntity> findByMail(String mail);
  Optional<UserEntity> findByName(String name);
}
