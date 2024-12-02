package br.com.fiap.postech.techchallenge.core.usecase.paymentorder;

import br.com.fiap.postech.techchallenge.application.interfaces.repository.IOrderRepository;
import br.com.fiap.postech.techchallenge.application.interfaces.repository.IPaymentOrderRepository;
import br.com.fiap.postech.techchallenge.core.domain.PaymentOrder;
import br.com.fiap.postech.techchallenge.core.domain.enums.OrderStatus;
import br.com.fiap.postech.techchallenge.core.domain.enums.PaymentStatus;
import br.com.fiap.postech.techchallenge.core.exception.BaseException;
import br.com.fiap.postech.techchallenge.core.exception.EntityNotFoundException;
import br.com.fiap.postech.techchallenge.core.exception.PaymentException;
import org.springframework.stereotype.Service;

@Service
public class MakePaymentUseCase {
    
    private final IPaymentOrderRepository paymentOrderRepository;
    private final IOrderRepository orderRepository;

    public MakePaymentUseCase(IPaymentOrderRepository paymentOrderRepository, IOrderRepository orderRepository) {
        this.paymentOrderRepository = paymentOrderRepository;
        this.orderRepository = orderRepository;
    }

    public void make(Long orderId) throws BaseException {
        PaymentOrder paymentOrder = paymentOrderRepository.findByOrderId(orderId);
        if(paymentOrder == null) {
            throw new EntityNotFoundException("Pagamento não encontrado!");
        }
        if(paymentOrder.getPaymentStatus() == PaymentStatus.FINISHED) {
            throw new PaymentException("Pagamento já realizado");
        }
        paymentOrder.setPaymentStatus(PaymentStatus.FINISHED);
        paymentOrder.getOrder().setOrderStatus(OrderStatus.RECEIVED);
        paymentOrderRepository.save(paymentOrder);
        orderRepository.save(paymentOrder.getOrder());
    }
}
