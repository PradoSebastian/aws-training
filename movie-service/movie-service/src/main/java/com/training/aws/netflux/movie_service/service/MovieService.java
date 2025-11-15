package com.training.aws.netflux.movie_service.service;

import com.training.aws.netflux.movie_service.domain.Genre;
import com.training.aws.netflux.movie_service.domain.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAll();
    List<Movie> getAll(Genre genre);
}
