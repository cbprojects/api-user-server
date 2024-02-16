package com.project.cafe.api.dao;

import com.project.cafe.api.model.UserEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
public interface IUserDao {
  public List<UserEntity> find();

  public UserEntity findById(Long id);

  public Optional<UserEntity> findByName(String name);

  public Optional<UserEntity> findByMail(String mail);

  public UserEntity createUser(UserEntity user);

  public UserEntity updateUser(UserEntity user);
}
