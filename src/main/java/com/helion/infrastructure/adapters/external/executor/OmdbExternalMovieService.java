package com.helion.infrastructure.adapters.external.executor;


import com.helion.domain.model.movie.MovieDomain;
import com.helion.infrastructure.adapters.external.ExternalMovieService;
import com.helion.infrastructure.adapters.external.help.OmdbSearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Component
public class OmdbExternalMovieService implements ExternalMovieService {

    private final WebClient webClient;

    @Value("${omdb.api.key}")
    private String apiKey;

    @Autowired
    public OmdbExternalMovieService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://www.omdbapi.com").build();
    }

    @Override
    public MovieDomain searchMovieByTitle(String title) {

        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("t", title)
                        .queryParam("apikey", apiKey)
                        .build())
                .retrieve()
                .bodyToMono(MovieDomain.class)
                .block();
    }

    @Override
    public List<MovieDomain> searchMovieByYear(String year) {
        OmdbSearchResponse response = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("s", "movie")   // búsqueda general
                        .queryParam("y", year)       // filtrado por año
                        .queryParam("apikey", apiKey)
                        .build())
                .retrieve()
                .bodyToMono(OmdbSearchResponse.class)
                .block();

        if (response == null || response.getSearch() == null) {
            return Collections.emptyList();
        }

        return new ArrayList<>(response.getSearch());
    }


}
