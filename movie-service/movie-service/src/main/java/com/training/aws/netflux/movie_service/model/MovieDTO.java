package com.training.aws.netflux.movie_service.model;

import com.training.aws.netflux.movie_service.domain.Genre;

import java.util.UUID;

public record MovieDTO(UUID id, String title, Integer releaseYear, Genre genre) {
}
