package br.com.fiap.postech.techchallenge.core.usecase.order;

import br.com.fiap.postech.techchallenge.application.interfaces.repository.IOrderRepository;
import br.com.fiap.postech.techchallenge.application.mapper.IOrderMapper;
import br.com.fiap.postech.techchallenge.application.dto.order.OrderDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllOrdersByCustomerUseCase {
    private final IOrderRepository orderRepository;
    private final IOrderMapper orderMapper;

    public FindAllOrdersByCustomerUseCase(IOrderRepository orderRepository, IOrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    public List<OrderDto> find(String cpf) {
        var response = orderRepository.findAllByCustomerCpf(cpf);
        return orderMapper.toOrdersDto(response);
    }
}
