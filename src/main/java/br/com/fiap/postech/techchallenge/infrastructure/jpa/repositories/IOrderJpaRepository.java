package br.com.fiap.postech.techchallenge.infrastructure.jpa.repositories;

import br.com.fiap.postech.techchallenge.core.domain.enums.OrderStatus;
import br.com.fiap.postech.techchallenge.infrastructure.jpa.entities.OrderEntity;

import java.util.List;

public interface IOrderJpaRepository  extends IJpaRepositoryBase<OrderEntity> {

    List<OrderEntity> findAllByOrderStatus(OrderStatus orderStatus);
    List<OrderEntity> findAllByCustomerCpf(String cpf);
}
