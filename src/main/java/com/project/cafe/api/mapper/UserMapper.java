package com.project.cafe.api.mapper;

import com.project.cafe.api.dto.UserDTO;
import com.project.cafe.api.model.UserTB;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
  UserDTO toDTO(UserTB entity);

  UserTB toEntity(UserDTO dto);

  List<UserDTO> map(List<UserTB> entities);
}
