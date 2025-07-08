package com.helion.infrastructure.adapters.persistence.mapper;

import com.helion.domain.model.user.UserDomain;
import com.helion.infrastructure.entities.UserEntity;
import org.mapstruct.Mapper;
import java.util.List;


@Mapper(componentModel = "spring")
public interface UserMapperEntity {
		
    UserDomain toDomain(UserEntity entity);
    
    UserEntity toEntity(UserDomain domain);

    List<UserDomain> toListDomain(List<UserEntity> entities);

    

}
