package com.helion.domain.model.movie;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class MovieDomain {

    private UUID id;
    @JsonProperty("Title")
    private String title;

    @JsonProperty("Year")
    private String year;

    @JsonProperty("Director")
    private String director;

    @JsonProperty("Genre")
    private String genre;

    @JsonProperty("Poster")
    private String poster;
    private UUID userId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public MovieDomain(UUID id, String title, String year, String director, String genre,
                 String poster,UUID userId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.director = director;
        this.genre = genre;
        this.userId = userId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }


}
