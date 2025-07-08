package com.helion.application.mapper;

import com.helion.application.dto.MovieDTO;
import com.helion.domain.model.movie.MovieDomain;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapperDTO {

    MovieDTO toDTO(MovieDomain movieDomain);

    MovieDomain toDomain(MovieDTO movieDTO);

    List<MovieDTO> toDTOList(List<MovieDomain> movieDomains);

    List<MovieDomain> toDomainList(List<MovieDTO> movieDTOS);
}
