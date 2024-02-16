package com.project.cafe.api.service.impl;

import com.project.cafe.api.dto.UserDTO;
import com.project.cafe.api.exception.imp.ModelNotFoundException;
import com.project.cafe.api.mapper.UserMapper;
import com.project.cafe.api.model.UserTB;
import com.project.cafe.api.repository.UserRepository;
import com.project.cafe.api.service.IUserService;
import com.project.cafe.api.util.ConstantsMessages;
import com.project.cafe.api.util.ConstantsTableNames;
import com.project.cafe.api.util.ConstantsValidations;
import com.project.cafe.api.util.PasswordUtil;
import com.project.cafe.api.util.Util;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

  // private IUserDao userDAO;
  private final UserRepository userRepository;

  private UserMapper mapper;

  @Override
  public List<UserDTO> find() {
    return mapper.map(userRepository.findAll());
  }

  @Override
  public UserDTO findById(long id) {
    return mapper.toDTO(userRepository.findById(id).get());
  }

  @Override
  public Optional<UserDTO> findByName(String name) {
    Optional<UserTB> opt = userRepository.findByName(name);

    return Optional.ofNullable(
      mapper.toDTO(opt.isPresent() ? opt.get() : null)
    );
  }

  @Override
  public Optional<UserDTO> findByMail(String mail) {
    Optional<UserTB> opt = userRepository.findByMail(mail);

    return Optional.ofNullable(
      mapper.toDTO(opt.isPresent() ? opt.get() : null)
    );
  }

  @Transactional
  @Override
  public UserDTO createUser(UserDTO user) {
    String msgError = Util.buildMessageErrors(
      Util.validaDatos(ConstantsTableNames.USER_TB, user)
    );
    if (StringUtils.isNotBlank(msgError)) {
      throw new ModelNotFoundException(msgError);
    }

    // Filtrar por correo
    Optional<UserTB> userFound = userRepository.findByMail(user.getMail());
    if (userFound.isPresent()) {
      throw new ModelNotFoundException(
        ConstantsMessages.ERROR_USER_ALREADY_EXIST_BY_MAIL
      );
    }

    UserTB entity = mapper.toEntity(user);
    setDefaultValues(entity, ConstantsValidations.PHASE_CREATE);
    return mapper.toDTO(userRepository.save(entity));
  }

  @Transactional
  @Override
  public UserDTO updateUser(UserDTO user) {
    String msgError = Util.buildMessageErrors(
      Util.validaDatos(ConstantsTableNames.USER_TB, user)
    );
    if (StringUtils.isNotBlank(msgError)) {
      throw new ModelNotFoundException(msgError);
    }

    Optional<UserTB> userFoundById = userRepository.findById(user.getId());
    if (!userFoundById.isPresent()) {
      throw new ModelNotFoundException(ConstantsMessages.ERROR_USER_NOT_FOUND);
    }

    // Filtrar por correo
    Optional<UserTB> userFound = userRepository.findByMail(user.getMail());
    if (
      userFound.isPresent() &&
      userFound.get().getId() != userFoundById.get().getId()
    ) {
      throw new ModelNotFoundException(
        ConstantsMessages.ERROR_USER_ALREADY_EXIST_BY_MAIL
      );
    }

    UserTB entity = mapper.toEntity(user);
    setDefaultValues(entity, ConstantsValidations.PHASE_UPDATE);
    entity.setPassword(Util.encriptarPassword(user.getPassword()));
    return mapper.toDTO(userRepository.save(entity));
  }

  @Transactional
  @Override
  public UserDTO login(String mail, String password) {
    UserDTO authUser = null;
    Optional<UserTB> userFound = userRepository.findByMail(mail);
    if (userFound.isPresent()) {
      String salt = PasswordUtil.getSalt(
        ConstantsValidations.SALT_ENCRIPTAR_CLAVE,
        password
      );

      boolean passwordVerificada = PasswordUtil.verifyUserPassword(
        password,
        userFound.get().getPassword(),
        salt
      );

      if (passwordVerificada && userFound.get().isActive()) {
        authUser = mapper.toDTO(userFound.get());
      }
    }

    return authUser;
  }

  private void setDefaultValues(UserTB entity, String phase) {
    LocalDateTime now = LocalDateTime.now();
    if (ConstantsValidations.PHASE_CREATE.equalsIgnoreCase(phase)) {
      entity.setCreateDate(now);
      entity.setCreateUser("SYSTEM");
      entity.setActive(true);
      entity.setId(null);
    }
    entity.setUpdateDate(now);
    entity.setUpdateUser("SYSTEM");
  }
}
