package com.training.aws.netflux.customer_service.mapper;

import com.training.aws.netflux.customer_service.domain.Customer;
import com.training.aws.netflux.customer_service.model.CustomerDTO;
import com.training.aws.netflux.customer_service.model.MovieDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(source = "movies", target = "recommendedMovies")
    CustomerDTO mapToDTO(Customer entity, List<MovieDTO> movies);

    Customer mapToEntity(CustomerDTO dto);

    List<CustomerDTO> mapToListDTO(List<Customer> listDto);

    List<Customer> mapToListEntities(List<CustomerDTO> listDto);

}
