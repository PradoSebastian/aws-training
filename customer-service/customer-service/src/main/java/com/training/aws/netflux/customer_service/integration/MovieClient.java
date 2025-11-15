package com.training.aws.netflux.customer_service.integration;

import com.training.aws.netflux.customer_service.domain.Genre;
import com.training.aws.netflux.customer_service.model.MovieDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
@Slf4j
public class MovieClient {
    private final RestClient client;

    public MovieClient(RestClient client) {
        this.client = client;
    }

    public List<MovieDTO> getMovies(Genre genre) {
        log.info("Calling GET Movies API with genre: {}", genre);
        List<MovieDTO> list = this.client.get()
                .uri("api/movies/{genre}", genre)
                .retrieve()
                .body(new ParameterizedTypeReference<List<MovieDTO>>() {
                });
        log.info("Retrieved list movies: {}", list);
        return list;
    }
}
