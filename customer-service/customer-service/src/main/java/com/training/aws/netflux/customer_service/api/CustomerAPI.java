package com.training.aws.netflux.customer_service.api;

import com.training.aws.netflux.customer_service.model.CustomerDTO;
import com.training.aws.netflux.customer_service.model.GenreUpdateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping(CustomerAPI.BASE_URL)
public interface CustomerAPI {

    String BASE_URL = "/api/customers";

    @GetMapping("/{id}")
    ResponseEntity<CustomerDTO> getCustomerById(@PathVariable UUID id);

    @PatchMapping("/{id}/genre")
    ResponseEntity<Void> updateGenreById(@PathVariable UUID id, @RequestBody GenreUpdateRequest request);
}
