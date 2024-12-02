package br.com.fiap.postech.techchallenge.core.usecase.order;

import br.com.fiap.postech.techchallenge.core.domain.enums.OrderStatus;
import br.com.fiap.postech.techchallenge.application.interfaces.repository.IOrderRepository;
import br.com.fiap.postech.techchallenge.core.exception.EntityNotFoundException;
import br.com.fiap.postech.techchallenge.application.mapper.IOrderMapper;
import br.com.fiap.postech.techchallenge.application.dto.order.DetailsOrderDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllOrdersByStatusUseCase {

    private final IOrderRepository orderRepository;
    private final IOrderMapper orderMapper;

    public FindAllOrdersByStatusUseCase(IOrderRepository orderRepository, IOrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    public List<DetailsOrderDto> find(OrderStatus orderStatus) throws EntityNotFoundException {
        var response = orderRepository.findAllByOrderStatusName(orderStatus);
        return orderMapper.toDetailsOrdersDto(response);
    }
}
