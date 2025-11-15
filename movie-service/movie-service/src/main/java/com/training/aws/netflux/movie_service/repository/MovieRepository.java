package com.training.aws.netflux.movie_service.repository;

import com.training.aws.netflux.movie_service.domain.Genre;
import com.training.aws.netflux.movie_service.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MovieRepository extends JpaRepository<Movie, UUID> {

    List<Movie> findByGenre(Genre genre);

}
