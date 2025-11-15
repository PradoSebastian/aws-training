package com.training.aws.netflux.movie_service;

import com.training.aws.netflux.movie_service.domain.Genre;
import com.training.aws.netflux.movie_service.mapper.MovieMapperImpl;
import com.training.aws.netflux.movie_service.model.MovieDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Import;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.util.List;

@Import({
		TestContainersConfiguration.class,
		MovieMapperImpl.class
})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
class MovieServiceApplicationTests {

	@Autowired
	private TestRestTemplate template;

	@Test
	void health() {
		ResponseEntity<Object> responseEntity = this.template.getForEntity("/actuator/health", Object.class);
		Assertions.assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
	}

	@Test
	void allMovies() {
		List<MovieDTO> movies = getMovies("/api/movies");
		Assertions.assertEquals(6, movies.size());
	}

	@Test
	void allMoviesByGenre() {
		List<MovieDTO> movies = getMovies("/api/movies/genre/ACTION");
		Assertions.assertEquals(3, movies.size());
		Assertions.assertTrue(movies.stream().map(MovieDTO::genre).allMatch(Genre.ACTION::equals));
	}

	private List<MovieDTO> getMovies(String uri) {
		RequestEntity<Object> requestEntity = new RequestEntity<>(HttpMethod.GET, URI.create(uri));
		ResponseEntity<List<MovieDTO>> responseEntity = this.template.exchange(requestEntity, new ParameterizedTypeReference<>() {});
		Assertions.assertNotNull(responseEntity.getBody());
		log.info("response: {}", responseEntity.getBody());
		return responseEntity.getBody();
	}

}
