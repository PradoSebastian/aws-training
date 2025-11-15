package com.training.aws.netflux.customer_service.repository;

import com.training.aws.netflux.customer_service.domain.Genre;
import com.training.aws.netflux.customer_service.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {}
