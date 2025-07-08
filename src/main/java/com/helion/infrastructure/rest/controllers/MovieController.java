package com.helion.infrastructure.rest.controllers;


import com.helion.application.dto.MovieDTO;
import com.helion.application.services.MovieService;
import com.helion.infrastructure.rest.response.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/dummy")
    public MovieDTO getMovies() {
        return new MovieDTO();
    }

    @PostMapping("/register")
    public ResponseEntity<MovieDTO> registerMovie(@RequestBody MovieDTO movieDTO) {

        return ResponseEntity.ok(null);
    }

    @GetMapping("/t")
    public ResponseEntity<MovieDTO> searchMovieByTitle(@RequestParam String title) {
        MovieDTO movie = movieService.searchMoviesByTitle(title);
        return ResponseEntity.ok(movie);
    }

}
