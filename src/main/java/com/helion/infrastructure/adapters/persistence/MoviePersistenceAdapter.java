package com.helion.infrastructure.adapters.persistence;

import com.helion.domain.model.movie.MovieDomain;
import com.helion.domain.ports.output.MovieRepositoryPort;
import com.helion.infrastructure.adapters.external.ExternalMovieService;
import com.helion.infrastructure.adapters.persistence.mapper.MovieMapperEntity;
import com.helion.infrastructure.repositories.MovieJparepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class MoviePersistenceAdapter implements MovieRepositoryPort {

    private final MovieJparepository movieJparepository;
    private final MovieMapperEntity movieMapperEntity;
    private final ExternalMovieService externalMovieService;


    @Override
    public void save(MovieDomain movieDomain) {
        movieJparepository.save(movieMapperEntity.toEntity(movieDomain));
    }

    @Override
    public Optional<MovieDomain> findMovieById(UUID id) {
        return movieJparepository.findById(id)
                .map(movieMapperEntity::toDomain);
    }

    @Override
    public List<MovieDomain> findMoviesByUserId(UUID userId) {
        return List.of();
    }

    @Override
    public MovieDomain getMovieByTitle(String title) {
        System.out.println(externalMovieService.searchMovieByTitle(title).getDirector());
        return externalMovieService.searchMovieByTitle(title);
    }

    @Override
    public List<MovieDomain> getMoviesByGenre(String genre) {
        return movieMapperEntity.toDomainList(
                movieJparepository.findByGenre(genre));
    }

    @Override
    public List<MovieDomain> getMoviesByYear(String year) {
        return  externalMovieService.searchMovieByYear(year);
    }

    @Override
    public List<MovieDomain> getMoviesByDirector(String director) {
        return List.of();
    }

    @Override
    public MovieDomain update(MovieDomain movieDTO) {
        return null;
    }

    @Override
    public void delete(UUID id) {
        movieJparepository.deleteById(id);

    }

    @Override
    public List<MovieDomain> findAllMovies() {
        return movieMapperEntity.toDomainList(
                movieJparepository.findAll()
        );
    }
}
