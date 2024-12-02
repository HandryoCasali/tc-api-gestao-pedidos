package br.com.fiap.postech.techchallenge.infrastructure.repositorio;

import br.com.fiap.postech.techchallenge.application.interfaces.repository.ICustomerRepository;
import br.com.fiap.postech.techchallenge.core.domain.Customer;
import br.com.fiap.postech.techchallenge.core.exception.EntityNotFoundException;
import br.com.fiap.postech.techchallenge.application.mapper.ICustomerMapper;
import br.com.fiap.postech.techchallenge.infrastructure.jpa.entities.CustomerEntity;
import br.com.fiap.postech.techchallenge.infrastructure.jpa.repositories.ICustomerJpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public class CustomerRepository extends RepositoryBase<Customer, CustomerEntity> implements ICustomerRepository {

    private final ICustomerJpaRepository repository;
    private final ICustomerMapper mapper;

    public CustomerRepository( ICustomerJpaRepository repository, ICustomerMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Customer findByCpf(String cpf) throws EntityNotFoundException {
        var result = repository.findByCpf(cpf);
        if(result.isEmpty()) throw new EntityNotFoundException("Cliente não encontrado!");
        return mapper.toDomain(result.get());
    }

    @Override
    public boolean existsByCpf(String cpf) {
        return repository.existsByCpf(cpf);
    }
}
