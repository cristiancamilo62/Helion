package com.helion.infrastructure.adapters.external.help;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OmdbDetailResponse {
    @JsonProperty("Title")
    private String title;

    @JsonProperty("Year")
    private String year;

    @JsonProperty("Director")
    private String director;

    @JsonProperty("Genre")
    private String genre;

    @JsonProperty("Plot")
    private String plot;

    @JsonProperty("Poster")
    private String poster;

    @JsonProperty("imdbID")
    private String imdbID;

    @JsonProperty("imdbRating")
    private String imdbRating;

    @JsonProperty("Runtime")
    private String runtime;

    @JsonProperty("Released")
    private String released;

    @JsonProperty("Actors")
    private String actors;

    @JsonProperty("Writer")
    private String writer;

    @JsonProperty("Language")
    private String language;

    @JsonProperty("Country")
    private String country;

    @JsonProperty("Awards")
    private String awards;

    @JsonProperty("Response")
    private String response;

    @JsonProperty("Error")
    private String error;

}