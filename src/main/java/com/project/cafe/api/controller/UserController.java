package com.project.cafe.api.controller;

import com.project.cafe.api.dto.StandardResponseDTO;
import com.project.cafe.api.dto.UserDTO;
import com.project.cafe.api.exception.imp.ModelNotFoundException;
import com.project.cafe.api.service.IUserService;
import com.project.cafe.api.util.ConstantsMessages;
import com.project.cafe.api.util.Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

  @Value("${rest.request.header}")
  private String REQUEST_HEADER;

  private IUserService userService;

  @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<StandardResponseDTO> find() {
    try {
      return new ResponseEntity<>(
        new StandardResponseDTO(userService.find()),
        HttpStatus.OK
      );
    } catch (Exception e) {
      throw new ModelNotFoundException(e.getMessage());
    }
  }

  @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<StandardResponseDTO> findByName(
    @RequestParam String name
  ) {
    try {
      return new ResponseEntity<>(
        new StandardResponseDTO(userService.findByName(name)),
        HttpStatus.OK
      );
    } catch (Exception e) {
      throw new ModelNotFoundException(e.getMessage());
    }
  }

  @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<StandardResponseDTO> findByMail(
    @RequestParam String mail
  ) {
    try {
      return new ResponseEntity<>(
        new StandardResponseDTO(userService.findByMail(mail)),
        HttpStatus.OK
      );
    } catch (Exception e) {
      throw new ModelNotFoundException(e.getMessage());
    }
  }

  @PostMapping(
    value = "/login",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  public ResponseEntity<StandardResponseDTO> login(
    @RequestBody UserDTO request
  ) {
    try {
      UserDTO authUser = null;
      if (
        request != null &&
        !StringUtils.isBlank(request.getMail()) &&
        !StringUtils.isBlank(request.getPassword())
      ) {
        authUser = userService.login(request.getMail(), request.getPassword());
        if (authUser == null) {
          throw new ModelNotFoundException(
            ConstantsMessages.ERROR_LOGIN_INACTIVE_OR_BAD_REQUEST
          );
        }
      } else {
        throw new ModelNotFoundException(ConstantsMessages.ERROR_NO_DATA);
      }

      return new ResponseEntity<>(
        new StandardResponseDTO(authUser),
        HttpStatus.OK
      );
    } catch (Exception e) {
      throw new ModelNotFoundException(e.getMessage());
    }
  }

  @PostMapping(
    value = "/password/encript",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  public ResponseEntity<StandardResponseDTO> encriptPassword(
    @RequestBody UserDTO request
  ) {
    try {
      UserDTO userCrypt = null;
      if (request != null && !StringUtils.isBlank(request.getPassword())) {
        userCrypt = new UserDTO();
        userCrypt.setPassword(Util.encriptarPassword(request.getPassword()));
      } else {
        throw new ModelNotFoundException(ConstantsMessages.ERROR_NO_DATA);
      }

      return new ResponseEntity<>(
        new StandardResponseDTO(userCrypt),
        HttpStatus.OK
      );
    } catch (Exception e) {
      throw new ModelNotFoundException(e.getMessage());
    }
  }

  @PostMapping(
    value = "",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  public ResponseEntity<StandardResponseDTO> createUser(
    @RequestBody UserDTO request
  ) {
    try {
      return new ResponseEntity<>(
        new StandardResponseDTO(userService.createUser(request)),
        HttpStatus.OK
      );
    } catch (Exception e) {
      throw new ModelNotFoundException(e.getMessage());
    }
  }

  @PutMapping(
    value = "",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  public ResponseEntity<StandardResponseDTO> updateUser(
    @RequestBody UserDTO request
  ) {
    try {
      return new ResponseEntity<>(
        new StandardResponseDTO(userService.updateUser(request)),
        HttpStatus.OK
      );
    } catch (Exception e) {
      throw new ModelNotFoundException(e.getMessage());
    }
  }
}
