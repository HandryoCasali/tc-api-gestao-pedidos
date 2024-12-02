package br.com.fiap.postech.techchallenge.infrastructure.jpa.repositories;

import br.com.fiap.postech.techchallenge.infrastructure.jpa.entities.CustomerEntity;

import java.util.Optional;

public interface ICustomerJpaRepository extends IJpaRepositoryBase<CustomerEntity> {
    Optional<CustomerEntity> findByCpf(String cpf);
    boolean existsByCpf(String cpf);
}
