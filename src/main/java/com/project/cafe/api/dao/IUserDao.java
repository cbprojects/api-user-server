package com.project.cafe.api.dao;

import com.project.cafe.api.model.UserTB;
import java.util.List;
import java.util.Optional;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
public interface IUserDao {
  public List<UserTB> find();

  public UserTB findById(Long id);

  public Optional<UserTB> findByName(String name);

  public Optional<UserTB> findByMail(String mail);

  public UserTB createUser(UserTB user);

  public UserTB updateUser(UserTB user);
}
