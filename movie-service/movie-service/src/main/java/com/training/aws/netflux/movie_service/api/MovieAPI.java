package com.training.aws.netflux.movie_service.api;

import com.training.aws.netflux.movie_service.domain.Genre;
import com.training.aws.netflux.movie_service.model.MovieDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(MovieAPI.BASE_URL)
public interface MovieAPI {

    String BASE_URL = "/api/movies";

    @GetMapping
    ResponseEntity<List<MovieDTO>> getAll();

    @GetMapping("/genre/{genre}")
    ResponseEntity<List<MovieDTO>> getAll(@PathVariable Genre genre);
}
