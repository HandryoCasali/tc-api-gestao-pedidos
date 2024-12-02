package br.com.fiap.postech.techchallenge.infrastructure.gateway.mercadopago;

import lombok.Data;

@Data
public class MerchantOrderEvent {
    private String resource;
    private String topic;
}
