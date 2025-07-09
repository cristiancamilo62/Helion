package com.helion.infrastructure.adapters.persistence.mapper;

import com.helion.domain.model.movie.MovieDomain;
import com.helion.infrastructure.entities.MovieEntity;
import com.helion.infrastructure.entities.UserEntity;
import org.mapstruct.*;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface MovieMapperEntity {

    @Mappings({
            @Mapping(target = "user", source = "userId", qualifiedByName = "mapToUserEntity")
    })
    MovieEntity toEntity(MovieDomain movieDomain);

    @Mappings({
            @Mapping(target = "userId", source = "user.id")
    })
    MovieDomain toDomain(MovieEntity movieEntity);

    List<MovieDomain> toDomainList(List<MovieEntity> movieEntities);

    List<MovieEntity> toEntityList(List<MovieDomain> movieDomains);

    // Mapeo personalizado para convertir el userId a un UserEntity con solo el ID
    @Named("mapToUserEntity")
    static UserEntity mapToUserEntity(UUID userId) {
        if (userId == null) return null;
        UserEntity user = new UserEntity();
        user.setId(userId);
        return user;
    }
}
