package br.com.fiap.postech.techchallenge.core.domain;

import br.com.fiap.postech.techchallenge.core.domain.enums.PaymentStatus;
import br.com.fiap.postech.techchallenge.core.domain.enums.PaymentType;
import br.com.fiap.postech.techchallenge.application.dto.payment.UpdatePaymentOrderDto;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class PaymentOrder extends BaseDomain {

    private PaymentStatus paymentStatus = PaymentStatus.PENDING;
    private BigDecimal totalPrice = BigDecimal.ZERO;
    private PaymentType paymentType;
    private Order order;
    private String qrCode;

    public PaymentOrder(Order order){
        if(order == null) throw new IllegalArgumentException("Necessário uma ordem de pedido");
        this.order = order;
        increasePrice(order.getTotalPrice());
    }
    public void addPaymentType(PaymentType type){
        this.paymentType = type;
    }

    private void increasePrice(BigDecimal price){
        this.totalPrice = totalPrice.add(price);
    }
    public void update(UpdatePaymentOrderDto paymentOrderDTO) {
        this.paymentStatus = paymentOrderDTO.getPaymentStatus();
        this.totalPrice = paymentOrderDTO.getTotalPrice();
        this.paymentType = paymentOrderDTO.getPaymentType();
    }
}
