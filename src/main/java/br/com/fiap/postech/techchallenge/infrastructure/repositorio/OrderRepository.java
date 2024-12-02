package br.com.fiap.postech.techchallenge.infrastructure.repositorio;

import br.com.fiap.postech.techchallenge.application.interfaces.repository.IOrderRepository;
import br.com.fiap.postech.techchallenge.core.domain.Order;
import br.com.fiap.postech.techchallenge.core.domain.enums.OrderStatus;
import br.com.fiap.postech.techchallenge.application.mapper.IOrderMapper;
import br.com.fiap.postech.techchallenge.infrastructure.jpa.entities.OrderEntity;
import br.com.fiap.postech.techchallenge.infrastructure.jpa.repositories.IOrderJpaRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository extends RepositoryBase<Order, OrderEntity> implements IOrderRepository {

    private final IOrderJpaRepository repository;
    private final IOrderMapper mapper;

    public OrderRepository(IOrderJpaRepository repository, IOrderMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<Order> findAll() {
        Sort sortOrder = Sort.by("orderStatus").descending()
                .and(Sort.by("creationTime").descending());

        List<OrderEntity> entities = repository.findAll(sortOrder)
                .stream()
                .filter(x -> !x.getOrderStatus().name().equals(OrderStatus.FINISHED.name()))
                .toList();

        return mapper.toDomains(entities);
    }

    @Override
    public List<Order> findAllByOrderStatusName(OrderStatus orderStatus) {
        var entities = repository.findAllByOrderStatus(orderStatus);
        return mapper.toDomains(entities);
    }

    @Override
    public List<Order> findAllByCustomerCpf(String cpf) {
        var entities = repository.findAllByCustomerCpf(cpf);
        return mapper.toDomains(entities);
    }
}
