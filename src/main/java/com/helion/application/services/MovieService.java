package com.helion.application.services;

import com.helion.application.dto.MovieDTO;
import com.helion.application.dto.UserDTO;
import com.helion.application.mapper.MovieMapperDTO;
import com.helion.domain.model.movie.MovieDomain;
import com.helion.domain.ports.input.MovieServicePort;
import com.helion.domain.ports.input.UserServicePort;
import com.helion.domain.ports.output.MovieRepositoryPort;
import com.helion.domain.ports.output.UserRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class MovieService implements MovieServicePort {

    private final MovieRepositoryPort movieRepository;
    private final MovieMapperDTO movieMapperDTO;

    @Override
    public void createMovie(MovieDTO movie) {

        MovieDomain movieSave = movieMapperDTO.toDomain(movie);

        movieSave.setId(UUID.randomUUID());

        movieSave.setUserId(movie.getUserId());

        movieSave.setCreatedAt(LocalDateTime.now());

        movieRepository.save(movieSave);
    }

    @Override
    public Optional<MovieDTO> getMovieById(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<MovieDTO> getMoviesByUserId(UUID userId) {

        return movieMapperDTO.toDTOList(movieRepository.findMoviesByUserId(userId));
    }

    @Override
    public List<MovieDTO> searchMoviesByTitle(String title) {
        return movieMapperDTO.toDTOList(movieRepository.getMoviesByTitle(title));
    }

    @Override
    public MovieDTO searchMovieByTitle(String title) {
        return movieMapperDTO.toDTO(movieRepository.getMovieByTitle(title));
    }

    @Override
    public List<MovieDTO> searchMoviesByGenre(String genre) {
        return List.of();
    }

    @Override
    public List<MovieDTO> searchMoviesByYear(String year) {
        return movieMapperDTO.toDTOList(movieRepository.getMoviesByYear(year));
    }

    @Override
    public List<MovieDTO> searchMoviesByDirector(String director) {
        return List.of();
    }

    @Override
    public MovieDTO updateMovie(MovieDTO movieDTO) {
        return null;
    }

    @Override
    public void deleteMovie(UUID id) {
        movieRepository.delete(id);

    }

    @Override
    public List<MovieDTO> getAllMovies() {
        return List.of();
    }
}
