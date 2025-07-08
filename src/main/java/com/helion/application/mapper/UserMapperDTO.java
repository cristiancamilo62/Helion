package com.helion.application.mapper;

import com.helion.application.dto.UserDTO;
import com.helion.domain.model.user.UserDomain;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapperDTO {

	UserDomain toDomain(UserDTO dto);

    UserDTO toDTO(UserDomain domain);

    List<UserDTO> toDTOList(List<UserDomain> domains);
}