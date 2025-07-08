package com.helion.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Movies")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovieEntity {

    @Id
    @Column(name = "movie_id")
    private UUID id;

    @Column(name = "title")
    private String title;

    @Column(name = "year")
    private String year;

    @Column(name = "director")
    private String director;

    @Column(name = "genre")
    private String genre;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id") // clave foránea
    private UserEntity user;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
