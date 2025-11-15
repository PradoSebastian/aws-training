package com.training.aws.netflux.movie_service.controller;

import com.training.aws.netflux.movie_service.api.MovieAPI;
import com.training.aws.netflux.movie_service.domain.Genre;
import com.training.aws.netflux.movie_service.mapper.MovieMapper;
import com.training.aws.netflux.movie_service.model.MovieDTO;
import com.training.aws.netflux.movie_service.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MovieController implements MovieAPI {

    private final MovieService service;
    private final MovieMapper mapper;

    @Override
    public ResponseEntity<List<MovieDTO>> getAll() {
        return ResponseEntity.ok(mapper.mapToListDTO(service.getAll()));
    }

    @Override
    public ResponseEntity<List<MovieDTO>> getAll(Genre genre) {
        return ResponseEntity.ok(mapper.mapToListDTO(service.getAll(genre)));
    }
}
