package br.com.fiap.postech.techchallenge.core.usecase.order;

import br.com.fiap.postech.techchallenge.application.interfaces.repository.IOrderRepository;
import br.com.fiap.postech.techchallenge.core.domain.enums.OrderStatus;
import br.com.fiap.postech.techchallenge.core.exception.EntityNotFoundException;
import br.com.fiap.postech.techchallenge.application.mapper.IOrderMapper;
import br.com.fiap.postech.techchallenge.application.dto.order.OrderDto;
import org.springframework.stereotype.Service;

@Service
public class UpdateOrderUseCase {

    private final IOrderRepository orderRepository;
    private final IOrderMapper orderMapper;

    public UpdateOrderUseCase(IOrderRepository orderRepository, IOrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    public OrderDto update(Long id, OrderStatus orderStatus) throws EntityNotFoundException {
        var entity = orderRepository.findById(id);
        entity.updateOrderStatus(orderStatus);
        orderRepository.save(entity);
        return orderMapper.toOrderDto(entity);
    }
}
