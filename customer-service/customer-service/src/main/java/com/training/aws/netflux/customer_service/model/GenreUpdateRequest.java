package com.training.aws.netflux.customer_service.model;

import com.training.aws.netflux.customer_service.domain.Genre;

public record GenreUpdateRequest(Genre favoriteGenre) {
}
