package br.com.fiap.postech.techchallenge.application.interfaces.repository;

import br.com.fiap.postech.techchallenge.core.domain.PaymentOrder;
import br.com.fiap.postech.techchallenge.core.domain.enums.PaymentStatus;

import java.util.List;

public interface IPaymentOrderRepository extends IRepositoryBase<PaymentOrder> {
    List<PaymentOrder> findAllByPaymentStatusName(PaymentStatus paymentStatus);

    PaymentOrder findByOrderId(Long orderId);
}
