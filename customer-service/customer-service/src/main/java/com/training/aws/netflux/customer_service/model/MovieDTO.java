package com.training.aws.netflux.customer_service.model;

import com.training.aws.netflux.customer_service.domain.Genre;

import java.util.UUID;

public record MovieDTO(UUID id, String title, Integer releaseYear, Genre genre) {
}
