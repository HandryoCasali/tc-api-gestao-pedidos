package br.com.fiap.postech.techchallenge.core.usecase.customer;

import br.com.fiap.postech.techchallenge.core.exception.EntityNotFoundException;
import br.com.fiap.postech.techchallenge.application.mapper.ICustomerMapper;
import br.com.fiap.postech.techchallenge.infrastructure.repositorio.CustomerRepository;
import br.com.fiap.postech.techchallenge.application.dto.customer.CustomerDto;
import org.springframework.stereotype.Service;

@Service
public class FindCustomerByCpfUseCase {
    private final CustomerRepository customerRepository;
    private final ICustomerMapper mapper;

    public FindCustomerByCpfUseCase(CustomerRepository customerRepository, ICustomerMapper mapper) {
        this.customerRepository = customerRepository;
        this.mapper = mapper;
    }

    public CustomerDto find(String cpf) throws EntityNotFoundException {
        var customer = customerRepository.findByCpf(cpf);
        return mapper.toCustomerDto(customer);
    }

}
