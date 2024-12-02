package br.com.fiap.postech.techchallenge.application.dto.order;

import br.com.fiap.postech.techchallenge.core.domain.enums.OrderStatus;
import br.com.fiap.postech.techchallenge.application.dto.combo.ComboDto;
import br.com.fiap.postech.techchallenge.application.dto.customer.CustomerDto;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class DetailsOrderDto {
    private Long id;
    private List<ComboDto> combos;
    private BigDecimal totalPrice;
    private OrderStatus orderStatus;
    private CustomerDto customer;
    private String elapsedTime;
    private String estimatedTime;
}
