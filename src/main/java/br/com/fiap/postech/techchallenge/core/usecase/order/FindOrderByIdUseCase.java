package br.com.fiap.postech.techchallenge.core.usecase.order;

import br.com.fiap.postech.techchallenge.application.interfaces.repository.IOrderRepository;
import br.com.fiap.postech.techchallenge.core.domain.Order;
import br.com.fiap.postech.techchallenge.core.domain.enums.OrderStatus;
import br.com.fiap.postech.techchallenge.core.exception.EntityNotFoundException;
import br.com.fiap.postech.techchallenge.application.mapper.IOrderMapper;
import br.com.fiap.postech.techchallenge.application.dto.order.DetailsOrderDto;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class FindOrderByIdUseCase {

    private final IOrderRepository orderRepository;
    private final IOrderMapper orderMapper;

    public FindOrderByIdUseCase(IOrderRepository orderRepository, IOrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    public DetailsOrderDto find(Long id) throws EntityNotFoundException {
        Order order = orderRepository.findById(id);
        DetailsOrderDto dto = orderMapper.toDetailsOrderDto(order);
        String elapsedtime = createElapsedTime(order);
        dto.setElapsedTime(elapsedtime);
        return dto;
    }

    private String createElapsedTime(Order order) {
        LocalDateTime finishedTime = LocalDateTime.now();

        if(order.getOrderStatus() == OrderStatus.FINISHED) {
            finishedTime = order.getFinishedTime();
        }

        Duration duration = Duration.between(order.getCreationTime(), finishedTime);
        long seconds = duration.getSeconds();

        long hours = seconds / 3600;
        long minutes = (seconds % 3600) / 60;
        long secs = seconds % 60;

        return String.format("%02d:%02d:%02d", hours, minutes, secs);
    }
}
