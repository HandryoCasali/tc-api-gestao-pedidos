package br.com.fiap.postech.techchallenge.application.mapper;

import br.com.fiap.postech.techchallenge.core.domain.Order;
import br.com.fiap.postech.techchallenge.infrastructure.jpa.entities.OrderEntity;
import br.com.fiap.postech.techchallenge.application.dto.order.DetailsOrderDto;
import br.com.fiap.postech.techchallenge.application.dto.order.OrderDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {IProductMapper.class, IAddonMapper.class, IOrderStatusMapper.class})
public interface IOrderMapper extends IBaseDomainMapper<Order, OrderEntity> {

    OrderDto toOrderDto(Order order);

    List<OrderDto> toOrdersDto(List<Order> domains);
    List<DetailsOrderDto> toDetailsOrdersDto(List<Order> domains);


    DetailsOrderDto toDetailsOrderDto(Order order);
}
