package br.com.fiap.postech.techchallenge.infrastructure.controllers;

import br.com.fiap.postech.techchallenge.core.exception.BaseException;
import br.com.fiap.postech.techchallenge.application.dto.payment.PaymentOrderDTO;
import br.com.fiap.postech.techchallenge.core.exception.EntityNotFoundException;
import br.com.fiap.postech.techchallenge.core.usecase.paymentorder.ConfirmPaymentUseCase;
import br.com.fiap.postech.techchallenge.core.usecase.paymentorder.FindPaymentOrderByOrderIdUseCase;
import br.com.fiap.postech.techchallenge.infrastructure.gateway.mercadopago.MerchantOrderEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/paymentOrder")
public class PaymentOrderController {
    private final FindPaymentOrderByOrderIdUseCase findPaymentOrderByOrderIdUseCase;
    private final ConfirmPaymentUseCase confirmPaymentUseCase;

    @GetMapping
    public ResponseEntity<PaymentOrderDTO> findByOrderId(@RequestParam Long orderId) throws EntityNotFoundException {
        PaymentOrderDTO paymentOrderDTO = findPaymentOrderByOrderIdUseCase.find(orderId);
        return ResponseEntity.ok(paymentOrderDTO);
    }

    @PostMapping("makePayment")
    public ResponseEntity<Void> makePayment(@RequestBody MerchantOrderEvent merchantOrder) throws BaseException {
        log.info("Recebido notificação de pagamento."+merchantOrder);
        confirmPaymentUseCase.confirm(merchantOrder);
        return ResponseEntity.ok().build();
    }

}
