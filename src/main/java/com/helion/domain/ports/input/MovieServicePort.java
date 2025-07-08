package com.helion.domain.ports.input;

import com.helion.application.dto.MovieDTO;
import com.helion.application.dto.UserDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MovieServicePort {

    void createMovie(MovieDTO movieDTO);

    Optional<MovieDTO> getMovieById(UUID id);

    List<MovieDTO> getMoviesByUserId(UUID userId);

    MovieDTO searchMoviesByTitle(String title);

    List<MovieDTO> searchMoviesByGenre(String genre);

    List<MovieDTO> searchMoviesByYear(String year);

    List<MovieDTO> searchMoviesByDirector(String director);

    MovieDTO updateMovie(MovieDTO movieDTO);

    void deleteMovie(UUID id);

    List<MovieDTO> getAllMovies();
}
