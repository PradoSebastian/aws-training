package com.training.aws.netflux.customer_service.service;

import com.training.aws.netflux.customer_service.domain.Customer;
import com.training.aws.netflux.customer_service.model.CustomerDTO;
import com.training.aws.netflux.customer_service.model.GenreUpdateRequest;

import java.util.UUID;

public interface CustomerService {
    CustomerDTO getCustomerById(UUID id);
    void updateCustomerGenre(UUID id, GenreUpdateRequest request);
}
