package com.helion.infrastructure.repositories;

import com.helion.infrastructure.entities.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MovieJparepository extends JpaRepository<MovieEntity, UUID> {

    List<MovieEntity> findByGenre(String genre);

}
