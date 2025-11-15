package com.training.aws.netflux.movie_service.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;

    private Integer releaseYear;

    @Enumerated(EnumType.STRING)
    private Genre genre;
}
