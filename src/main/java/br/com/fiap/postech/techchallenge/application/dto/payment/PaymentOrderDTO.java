package br.com.fiap.postech.techchallenge.application.dto.payment;

import br.com.fiap.postech.techchallenge.core.domain.enums.PaymentStatus;
import br.com.fiap.postech.techchallenge.core.domain.enums.PaymentType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PaymentOrderDTO {
    private Long id;
    private PaymentStatus paymentStatusName;
    private BigDecimal totalPrice;
    private PaymentType paymentTypeName;
    private String qrCode;
}
