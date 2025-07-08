package com.helion.infrastructure.adapters.persistence.mapper;

import com.helion.domain.model.movie.MovieDomain;
import com.helion.infrastructure.entities.MovieEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapperEntity {

    MovieDomain toDomain(MovieEntity movieEntity);

    MovieEntity toEntity(MovieDomain movieDomain);

    List<MovieDomain> toDomainList(List<MovieEntity> movieEntities);

    List<MovieEntity> toEntityList(List<MovieDomain> movieDomains);
}
