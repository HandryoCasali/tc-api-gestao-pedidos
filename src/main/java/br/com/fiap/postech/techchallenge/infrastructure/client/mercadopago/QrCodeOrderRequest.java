package br.com.fiap.postech.techchallenge.infrastructure.client.mercadopago;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class QrCodeOrderRequest {

    private String external_reference;
    private String title;
    private String description;
    private String notification_url;
    private Double total_amount;
    private List<QrCodeItemRequest> items;

    @Data
    @AllArgsConstructor
    public static class QrCodeItemRequest{
        private String sku_number;
        private String category;
        private String title;
        private String description;
        private Double unit_price;
        private Integer quantity;
        private final String unit_measure = "unit";
        private Double total_amount;
    }

}

