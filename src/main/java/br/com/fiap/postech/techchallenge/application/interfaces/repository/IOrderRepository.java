package br.com.fiap.postech.techchallenge.application.interfaces.repository;

import br.com.fiap.postech.techchallenge.core.domain.Order;
import br.com.fiap.postech.techchallenge.core.domain.enums.OrderStatus;

import java.util.List;

public interface IOrderRepository extends IRepositoryBase<Order> {
    List<Order> findAll();
    List<Order> findAllByOrderStatusName(OrderStatus orderStatus);
    List<Order> findAllByCustomerCpf(String cpf);
}
