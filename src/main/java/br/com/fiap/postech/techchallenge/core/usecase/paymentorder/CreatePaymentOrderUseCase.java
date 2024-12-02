package br.com.fiap.postech.techchallenge.core.usecase.paymentorder;

import br.com.fiap.postech.techchallenge.core.domain.Order;
import br.com.fiap.postech.techchallenge.core.domain.PaymentOrder;
import br.com.fiap.postech.techchallenge.core.interfaces.api.IPaymentApi;
import br.com.fiap.postech.techchallenge.core.interfaces.api.PaymentCreated;
import br.com.fiap.postech.techchallenge.application.interfaces.repository.IPaymentOrderRepository;
import br.com.fiap.postech.techchallenge.application.mapper.IPaymentOrderMapper;
import br.com.fiap.postech.techchallenge.application.dto.payment.PaymentOrderDTO;
import org.springframework.stereotype.Service;

@Service
public class CreatePaymentOrderUseCase {
    private final IPaymentOrderRepository paymentOrderRepository;
    private final IPaymentOrderMapper mapper;
    private final IPaymentApi paymentApi;

    public CreatePaymentOrderUseCase(IPaymentOrderRepository paymentOrderRepository, IPaymentOrderMapper mapper, IPaymentApi paymentApi) {
        this.paymentOrderRepository = paymentOrderRepository;
        this.mapper = mapper;
        this.paymentApi = paymentApi;
    }

    public PaymentOrderDTO create(Order order){
        PaymentOrder payment = new PaymentOrder(order);
        PaymentCreated paymentCreated = paymentApi.createPaymentQrCode(order);
        payment.setQrCode(paymentCreated.getQrCode());
        var paymentSaved = paymentOrderRepository.save(payment);

        return mapper.toPaymentOrderDTO(paymentSaved);
    }
}
