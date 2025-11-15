package com.training.aws.netflux.customer_service;

import com.training.aws.netflux.customer_service.domain.Customer;
import com.training.aws.netflux.customer_service.domain.Genre;
import com.training.aws.netflux.customer_service.integration.MovieClient;
import com.training.aws.netflux.customer_service.mapper.CustomerMapperImpl;
import com.training.aws.netflux.customer_service.model.CustomerDTO;
import com.training.aws.netflux.customer_service.model.GenreUpdateRequest;
import com.training.aws.netflux.customer_service.model.MovieDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Import;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.web.client.RestClient;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@Import({
		TestContainersConfiguration.class,
		CustomerMapperImpl.class
})
@MockitoBean(types = {RestClient.class, MovieClient.class})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
class CustomerServiceApplicationTests {

	@Autowired
	private TestRestTemplate template;

	@Autowired
	private MovieClient movieClient;

	@Test
	void health() {
		ResponseEntity<Object> responseEntity = this.template.getForEntity("/actuator/health", Object.class);
		Assertions.assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
	}

	@Test
	void getCustomerByIdWithMovies() {
		Mockito.when(movieClient.getMovies(Mockito.any(Genre.class)))
				.thenReturn(List.of(
						new MovieDTO(UUID.randomUUID(), "test-movie", 1999, Genre.DRAMA),
						new MovieDTO(UUID.randomUUID(), "test-movie-2", 1999, Genre.ACTION)));

		RequestEntity<Object> requestEntity = new RequestEntity<>(HttpMethod.GET,
				URI.create("/api/customers/f04592a6-4fc6-4720-b2e4-fed6ab194c1c"));
		ResponseEntity<CustomerDTO> responseEntity = this.template.exchange(requestEntity,
				new ParameterizedTypeReference<>() {});

		Assertions.assertTrue(responseEntity.getStatusCode().is2xxSuccessful());

		CustomerDTO customer = responseEntity.getBody();

		Assertions.assertNotNull(customer);
		Assertions.assertEquals(2, customer.recommendedMovies().size());
	}

	@Test
	void getCustomerByIdNotFound() {
		RequestEntity<Object> requestEntity = new RequestEntity<>(HttpMethod.GET,
				URI.create("/api/customers/a04592a6-4fc6-4720-b2e4-fed6ab194c1c"));
		ResponseEntity<ProblemDetail> responseEntity = this.template.exchange(requestEntity,
				new ParameterizedTypeReference<>() {});

		Assertions.assertTrue(responseEntity.getStatusCode().is4xxClientError());

		ProblemDetail problemDetail = responseEntity.getBody();

		Assertions.assertNotNull(problemDetail);
		Assertions.assertEquals("Customer Not Found", problemDetail.getTitle());
	}

	@Test
	void updateGenreById() {
		GenreUpdateRequest request = new GenreUpdateRequest(Genre.COMEDY);

		RequestEntity<Object> requestEntity = new RequestEntity<>(request, HttpMethod.PATCH,
				URI.create("/api/customers/d2a5110a-1aca-4e79-8332-9b43270ffb8b/genre"));
		ResponseEntity<ProblemDetail> responseEntity = this.template.exchange(requestEntity,
				new ParameterizedTypeReference<>() {});

		Assertions.assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
		Assertions.assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
	}

}
