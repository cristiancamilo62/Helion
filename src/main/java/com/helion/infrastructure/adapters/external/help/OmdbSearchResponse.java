package com.helion.infrastructure.adapters.external.help;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.helion.domain.model.movie.MovieDomain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OmdbSearchResponse {
    @JsonProperty("Search")
    private List<MovieDomain> search;

    @JsonProperty("totalResults")
    private String totalResults;

    @JsonProperty("Response")
    private String response;
}