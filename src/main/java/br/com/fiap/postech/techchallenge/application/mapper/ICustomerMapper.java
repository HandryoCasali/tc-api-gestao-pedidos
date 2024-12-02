package br.com.fiap.postech.techchallenge.application.mapper;

import br.com.fiap.postech.techchallenge.core.domain.Customer;
import br.com.fiap.postech.techchallenge.infrastructure.jpa.entities.CustomerEntity;
import br.com.fiap.postech.techchallenge.application.dto.customer.CreateCustomerDto;
import br.com.fiap.postech.techchallenge.application.dto.customer.CustomerDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ICustomerMapper extends IBaseDomainMapper<Customer, CustomerEntity> {
    Customer toCustomer(CreateCustomerDto dto);

    CustomerDto toCustomerDto(Customer customerSaved);
}
