package br.com.fiap.postech.techchallenge.application.dto.payment;

import br.com.fiap.postech.techchallenge.core.domain.enums.PaymentStatus;
import br.com.fiap.postech.techchallenge.core.domain.enums.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class UpdatePaymentOrderDto {
    private PaymentStatus paymentStatus;
    private BigDecimal totalPrice;
    private PaymentType paymentType;
}
