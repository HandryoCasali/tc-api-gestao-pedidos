package br.com.fiap.postech.techchallenge.core.usecase.customer;

import br.com.fiap.postech.techchallenge.core.domain.Customer;
import br.com.fiap.postech.techchallenge.application.mapper.ICustomerMapper;
import br.com.fiap.postech.techchallenge.infrastructure.repositorio.CustomerRepository;
import br.com.fiap.postech.techchallenge.application.dto.customer.CreateCustomerDto;
import br.com.fiap.postech.techchallenge.application.dto.customer.CustomerDto;
import org.springframework.stereotype.Service;

@Service
public class CreateCustomerUseCase {
    private final CustomerRepository customerRepository;
    private final ICustomerMapper mapper;

    public CreateCustomerUseCase(CustomerRepository customerRepository, ICustomerMapper mapper) {
        this.customerRepository = customerRepository;
        this.mapper = mapper;
    }

    public CustomerDto create(CreateCustomerDto dto) {
        if(customerRepository.existsByCpf(dto.getCpf()))
            throw new IllegalArgumentException("Cliente já cadastrado!");

        Customer customer = mapper.toCustomer(dto);
        var customerSaved = customerRepository.save(customer);
        return mapper.toCustomerDto(customerSaved);
    }
}
