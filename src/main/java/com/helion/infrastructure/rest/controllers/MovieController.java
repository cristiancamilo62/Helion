package com.helion.infrastructure.rest.controllers;


import com.helion.application.dto.MovieDTO;
import com.helion.domain.ports.input.MovieServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/movies")
public class MovieController {

    private final MovieServicePort movieService;

    public MovieController(MovieServicePort movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/dummy")
    public MovieDTO getMovies() {
        return new MovieDTO();
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerMovie(@RequestBody MovieDTO movieDTO) {
        try {
            movieService.createMovie(movieDTO);
            return ResponseEntity.ok("Película registrada exitosamente");
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al registrar la película "+e.getMessage());
        }
    }


    @GetMapping("/t")
    public ResponseEntity<MovieDTO> searchMovieByTitle(@RequestParam String title) {
        MovieDTO movie = movieService.searchMovieByTitle(title);
        return ResponseEntity.ok(movie);
    }

    @GetMapping("/all")
    public ResponseEntity<List<MovieDTO>> searchMoviesByTitle(@RequestParam String title) {
        List<MovieDTO> movie = movieService.searchMoviesByTitle(title);
        return ResponseEntity.ok(movie);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<MovieDTO>> getMoviesByUserId(@PathVariable UUID userId) {
        List<MovieDTO> movies = movieService.getMoviesByUserId(userId);
        return ResponseEntity.ok(movies);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable UUID id) {
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }


}
