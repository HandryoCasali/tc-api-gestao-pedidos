package br.com.fiap.postech.techchallenge.infrastructure.client.mercadopago;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PaymentResponse {
    private String status;
    @JsonProperty("external_reference")
    private Long externalReference;
    @JsonProperty("order_status")
    private String orderStatus;
}
