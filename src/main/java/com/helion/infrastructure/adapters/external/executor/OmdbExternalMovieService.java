package com.helion.infrastructure.adapters.external.executor;


import com.helion.domain.model.movie.MovieDomain;
import com.helion.infrastructure.adapters.external.ExternalMovieService;
import com.helion.infrastructure.adapters.external.help.OmdbDetailResponse;
import com.helion.infrastructure.adapters.external.help.OmdbSearchItem;
import com.helion.infrastructure.adapters.external.help.OmdbSearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.*;


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

        MovieDomain a =  webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("t", title)
                        .queryParam("apikey", apiKey)
                        .build())
                .retrieve()
                .bodyToMono(MovieDomain.class)
                .block();

        System.out.println(a.getPoster());
        return a;
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

        return new ArrayList<>((Collection) response);
    }


    @Override
    public List<MovieDomain> searchMoviesByCTitle(String title) {
        List<MovieDomain> allMovies = new ArrayList<>();
        int page = 1;
        int maxPages = 2;

        while (page <= maxPages) {
            int finalPage = page;

            // Primera llamada: búsqueda general
            OmdbSearchResponse searchResponse = webClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .queryParam("s", title)
                            .queryParam("apikey", apiKey)
                            .queryParam("page", finalPage)
                            .queryParam("type", "movie") // Solo películas
                            .build())
                    .retrieve()
                    .bodyToMono(OmdbSearchResponse.class)
                    .block();

            // Verificar si hay resultados
            if (searchResponse == null ||
                    !"True".equals(searchResponse.getResponse()) ||
                    searchResponse.getSearch() == null ||
                    searchResponse.getSearch().isEmpty()) {
                break;
            }

            // Procesar cada película encontrada
            for (OmdbSearchItem item : searchResponse.getSearch()) {
                try {
                    // Segunda llamada: obtener detalles completos usando imdbID
                    OmdbDetailResponse detail = webClient.get()
                            .uri(uriBuilder -> uriBuilder
                                    .queryParam("i", item.getImdbID()) // Usar imdbID es más confiable
                                    .queryParam("apikey", apiKey)
                                    .queryParam("plot", "full") // Obtener plot completo
                                    .build())
                            .retrieve()
                            .bodyToMono(OmdbDetailResponse.class)
                            .block();

                    if (detail != null && "True".equals(detail.getResponse())) {
                        allMovies.add(new MovieDomain(
                                UUID.randomUUID(),
                                detail.getTitle(),
                                detail.getYear(),
                                detail.getDirector(),
                                detail.getGenre(),
                                detail.getPoster(),
                                null,
                                null,
                                null
                        ));
                    }
                } catch (Exception e) {
                    // Log del error y continuar con la siguiente película
                    System.err.println("Error obteniendo detalles para película: " + item.getTitle() + " - " + e.getMessage());
                }
            }

            page++;

            // Pequeña pausa para evitar rate limiting
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }

        return allMovies;
    }


    // Método auxiliar para validar detalles
    private boolean isValidDetail(OmdbDetailResponse detail) {
        return detail != null &&
                "True".equals(detail.getResponse()) &&
                detail.getTitle() != null;
    }


}
