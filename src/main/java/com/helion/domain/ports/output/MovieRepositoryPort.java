package com.helion.domain.ports.output;


import com.helion.domain.model.movie.MovieDomain;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MovieRepositoryPort {


    void save(MovieDomain movie);

    Optional<MovieDomain> findMovieById(UUID id);

    List<MovieDomain> findMoviesByUserId(UUID userId);

    MovieDomain getMovieByTitle(String title);

    List<MovieDomain> getMoviesByGenre(String genre);

    List<MovieDomain> getMoviesByYear(String year);

    List<MovieDomain> getMoviesByDirector(String director);

    MovieDomain update(MovieDomain movieDTO);

    void delete(UUID id);

    List<MovieDomain> findAllMovies();
}
