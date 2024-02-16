package com.project.cafe.api.service;

import com.project.cafe.api.exception.impl.ModelException;
import com.project.cafe.api.model.dto.UserDTO;
import java.util.List;
import java.util.Optional;

public interface IUserService {
  public List<UserDTO> find();

  public UserDTO findById(long id);

  public Optional<UserDTO> findByName(String name);

  public Optional<UserDTO> findByMail(String mail);

  public UserDTO createUser(UserDTO user) throws ModelException;

  public UserDTO updateUser(UserDTO user) throws ModelException;

  public UserDTO login(String mail, String password);
}
