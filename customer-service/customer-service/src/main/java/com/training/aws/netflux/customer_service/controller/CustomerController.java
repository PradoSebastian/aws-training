package com.training.aws.netflux.customer_service.controller;

import com.training.aws.netflux.customer_service.api.CustomerAPI;
import com.training.aws.netflux.customer_service.model.CustomerDTO;
import com.training.aws.netflux.customer_service.model.GenreUpdateRequest;
import com.training.aws.netflux.customer_service.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class CustomerController implements CustomerAPI {

    private final CustomerService service;

    @Override
    public ResponseEntity<CustomerDTO> getCustomerById(UUID id) {
        return ResponseEntity.ok(this.service.getCustomerById(id));
    }

    @Override
    public ResponseEntity<Void> updateGenreById(UUID id, GenreUpdateRequest request) {
        this.service.updateCustomerGenre(id, request);
        return ResponseEntity.noContent().build(); // 204
    }
}
