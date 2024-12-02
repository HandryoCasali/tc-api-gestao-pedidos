package br.com.fiap.postech.techchallenge.infrastructure.jpa.entities;

import br.com.fiap.postech.techchallenge.core.domain.enums.PaymentStatus;
import br.com.fiap.postech.techchallenge.core.domain.enums.PaymentType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "PaymentOrder")
public class PaymentOrderEntity extends EntityBase {

    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentStatus paymentStatus;

    @Column(nullable = false)
    private BigDecimal totalPrice;

    @OneToOne
    @JoinColumn(nullable = false)
    private OrderEntity order;

    @Column(nullable = false)
    private String qrCode;


}
