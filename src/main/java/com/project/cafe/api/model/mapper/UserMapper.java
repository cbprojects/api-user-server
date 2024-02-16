package com.project.cafe.api.model.mapper;

import com.project.cafe.api.model.UserEntity;
import com.project.cafe.api.model.dto.UserDTO;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
  UserDTO toDTO(UserEntity entity);

  UserEntity toEntity(UserDTO dto);

  List<UserDTO> map(List<UserEntity> entities);
}
