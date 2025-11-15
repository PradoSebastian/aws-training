package com.training.aws.netflux.movie_service.service.impl;

import com.training.aws.netflux.movie_service.domain.Genre;
import com.training.aws.netflux.movie_service.domain.Movie;
import com.training.aws.netflux.movie_service.repository.MovieRepository;
import com.training.aws.netflux.movie_service.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository repository;

    @Override
    public List<Movie> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Movie> getAll(Genre genre) {
        return repository.findByGenre(genre);
    }
}
