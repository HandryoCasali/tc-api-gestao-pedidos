package br.com.fiap.postech.techchallenge.application.dto.order;

import br.com.fiap.postech.techchallenge.core.domain.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long id;
    private String orderStatus;
    private BigDecimal totalPrice;
}
