package com.project.cafe.api.repository;

import com.project.cafe.api.model.UserTB;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserTB, Long> {
  Optional<UserTB> findByMail(String mail);
  Optional<UserTB> findByName(String name);
}
