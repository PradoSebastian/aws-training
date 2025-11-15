package com.training.aws.netflux.customer_service.model;

import com.training.aws.netflux.customer_service.domain.Genre;

import java.util.List;
import java.util.UUID;

public record CustomerDTO(UUID id, String name, Genre favoriteGenre, List<MovieDTO> recommendedMovies) {
}
