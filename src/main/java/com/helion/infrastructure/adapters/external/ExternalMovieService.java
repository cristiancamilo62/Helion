package com.helion.infrastructure.adapters.external;

import com.helion.application.dto.MovieDTO;
import com.helion.domain.model.movie.MovieDomain;

import java.util.List;
import java.util.Optional;

public interface ExternalMovieService {

    MovieDomain searchMovieByTitle(String title);

    List<MovieDomain> searchMovieByYear(String year);

    List<MovieDomain> searchMoviesByCTitle(String title);

}
