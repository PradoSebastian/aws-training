package com.training.aws.netflux.movie_service.mapper;

import com.training.aws.netflux.movie_service.domain.Movie;
import com.training.aws.netflux.movie_service.model.MovieDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    MovieDTO mapToDTO(Movie entity);

    Movie mapToEntity(MovieDTO dto);

    List<MovieDTO> mapToListDTO(List<Movie> listDto);

    List<Movie> mapToListEntities(List<MovieDTO> listDto);

}
