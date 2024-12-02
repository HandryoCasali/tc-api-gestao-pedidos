package br.com.fiap.postech.techchallenge.core.usecase.order;

import br.com.fiap.postech.techchallenge.application.dto.order.DetailsOrderDto;
import br.com.fiap.postech.techchallenge.application.interfaces.repository.IOrderRepository;
import br.com.fiap.postech.techchallenge.application.mapper.IOrderMapper;
import br.com.fiap.postech.techchallenge.core.domain.Order;
import br.com.fiap.postech.techchallenge.core.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllOrdersUseCase {

    private final IOrderRepository orderRepository;
    private final IOrderMapper orderMapper;

    public FindAllOrdersUseCase(IOrderRepository orderRepository, IOrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    public List<DetailsOrderDto> findAll() throws EntityNotFoundException {
        var response = orderRepository.findAll();
        return orderMapper.toDetailsOrdersDto(response);
    }

}
