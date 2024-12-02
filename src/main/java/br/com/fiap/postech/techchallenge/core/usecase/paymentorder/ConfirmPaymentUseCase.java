package br.com.fiap.postech.techchallenge.core.usecase.paymentorder;

import br.com.fiap.postech.techchallenge.core.exception.BaseException;
import br.com.fiap.postech.techchallenge.core.exception.PaymentException;
import br.com.fiap.postech.techchallenge.core.interfaces.api.IPaymentApi;
import br.com.fiap.postech.techchallenge.infrastructure.gateway.mercadopago.MerchantOrderEvent;
import br.com.fiap.postech.techchallenge.infrastructure.client.mercadopago.PaymentResponse;
import org.springframework.stereotype.Service;

@Service
public class ConfirmPaymentUseCase {

    private final IPaymentApi paymentApi;
    private final MakePaymentUseCase makePaymentUseCase;

    public ConfirmPaymentUseCase(IPaymentApi paymentApi, MakePaymentUseCase makePaymentUseCase) {
        this.paymentApi = paymentApi;
        this.makePaymentUseCase = makePaymentUseCase;
    }

    public void confirm(MerchantOrderEvent event) throws BaseException {

        if(!event.getTopic().equals("merchant_order")){
            throw new PaymentException("Pagamento não encontrado!");
        }

        PaymentResponse paymentResponse = paymentApi.getPayment(getPaymentId(event));

        if(paymentResponse.getStatus().equalsIgnoreCase("opened")){
            throw new PaymentException("Pagamento não realizado!");
        }

        Long orderId = paymentResponse.getExternalReference();

        makePaymentUseCase.make(orderId);
    }

    private String getPaymentId(MerchantOrderEvent event) {
        return event.getResource().split("merchant_orders/")[1];
    }
}
