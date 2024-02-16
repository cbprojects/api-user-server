package com.project.cafe.api.service;

import com.project.cafe.api.dto.UserDTO;
import java.util.List;
import java.util.Optional;

public interface IUserService {
  public List<UserDTO> find();

  public UserDTO findById(long id);

  public Optional<UserDTO> findByName(String name);

  public Optional<UserDTO> findByMail(String mail);

  public UserDTO createUser(UserDTO user);

  public UserDTO updateUser(UserDTO user);

  public UserDTO login(String mail, String password);
}
