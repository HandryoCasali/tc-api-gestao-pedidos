package br.com.fiap.postech.techchallenge.core.interfaces.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaymentCreated {
    private String idPayment;
    private String qrCode;
}
