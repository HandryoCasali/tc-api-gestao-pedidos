package br.com.fiap.postech.techchallenge.core.usecase.paymentorder;

import br.com.fiap.postech.techchallenge.application.dto.payment.PaymentOrderDTO;
import br.com.fiap.postech.techchallenge.application.interfaces.repository.IPaymentOrderRepository;
import br.com.fiap.postech.techchallenge.application.mapper.IPaymentOrderMapper;
import br.com.fiap.postech.techchallenge.core.domain.PaymentOrder;
import br.com.fiap.postech.techchallenge.core.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class FindPaymentOrderByOrderIdUseCase {

    private final IPaymentOrderRepository iPaymentOrderRepository;
    private final IPaymentOrderMapper iPaymentOrderMapper;

    public FindPaymentOrderByOrderIdUseCase(IPaymentOrderRepository iPaymentOrderRepository, IPaymentOrderMapper iPaymentOrderMapper) {
        this.iPaymentOrderRepository = iPaymentOrderRepository;
        this.iPaymentOrderMapper = iPaymentOrderMapper;
    }

    public PaymentOrderDTO find(Long orderId) throws EntityNotFoundException {
        PaymentOrder paymentOrder = iPaymentOrderRepository.findByOrderId(orderId);
        if(paymentOrder == null) throw new EntityNotFoundException("Pedido não encontrado!");
        return iPaymentOrderMapper.toPaymentOrderDTO(paymentOrder);
    }
}
