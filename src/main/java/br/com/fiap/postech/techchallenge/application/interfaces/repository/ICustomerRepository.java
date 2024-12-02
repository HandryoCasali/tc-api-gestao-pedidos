package br.com.fiap.postech.techchallenge.application.interfaces.repository;

import br.com.fiap.postech.techchallenge.core.domain.Customer;
import br.com.fiap.postech.techchallenge.core.exception.EntityNotFoundException;

public interface ICustomerRepository extends IRepositoryBase<Customer> {
    Customer findByCpf(String cpf) throws EntityNotFoundException;
    boolean existsByCpf(String cpf);
}
