package com.training.aws.netflux.customer_service.exception;

import java.util.UUID;

public class CustomerNotFoundException extends RuntimeException {

    private static final String MESSAGE = "Customer [id = %s] not found.";

    public CustomerNotFoundException(UUID id) {
        super(MESSAGE.formatted(id));
    }
}
