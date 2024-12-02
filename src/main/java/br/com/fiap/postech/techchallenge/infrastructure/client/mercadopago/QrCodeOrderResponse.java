package br.com.fiap.postech.techchallenge.infrastructure.client.mercadopago;

import lombok.Data;

@Data
public class QrCodeOrderResponse {
    private String in_store_order_id;
    private String qr_data;
}
