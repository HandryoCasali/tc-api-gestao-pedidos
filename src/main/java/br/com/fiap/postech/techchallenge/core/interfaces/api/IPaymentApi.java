package br.com.fiap.postech.techchallenge.core.interfaces.api;

import br.com.fiap.postech.techchallenge.core.domain.Order;
import br.com.fiap.postech.techchallenge.infrastructure.client.mercadopago.PaymentResponse;

public interface IPaymentApi {

    PaymentCreated createPaymentQrCode(Order order);
    PaymentResponse getPayment(String id);
}
