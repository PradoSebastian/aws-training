package com.training.aws.netflux.customer_service.service.impl;

import com.training.aws.netflux.customer_service.domain.Customer;
import com.training.aws.netflux.customer_service.domain.Genre;
import com.training.aws.netflux.customer_service.exception.CustomerNotFoundException;
import com.training.aws.netflux.customer_service.integration.MovieClient;
import com.training.aws.netflux.customer_service.mapper.CustomerMapper;
import com.training.aws.netflux.customer_service.model.CustomerDTO;
import com.training.aws.netflux.customer_service.model.GenreUpdateRequest;
import com.training.aws.netflux.customer_service.model.MovieDTO;
import com.training.aws.netflux.customer_service.repository.CustomerRepository;
import com.training.aws.netflux.customer_service.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;
    private final MovieClient movieClient;
    private final CustomerMapper mapper;

    @Override
    public CustomerDTO getCustomerById(UUID id) {
        Customer customer = repository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
        List<MovieDTO> recommendedMovies = this.movieClient.getMovies(customer.getFavoriteGenre());
        return mapper.mapToDTO(customer, recommendedMovies);
    }

    @Override
    public void updateCustomerGenre(UUID id, GenreUpdateRequest request) {
        Customer customer = repository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
        customer.setFavoriteGenre(request.favoriteGenre());
        this.repository.save(customer);
    }
}
