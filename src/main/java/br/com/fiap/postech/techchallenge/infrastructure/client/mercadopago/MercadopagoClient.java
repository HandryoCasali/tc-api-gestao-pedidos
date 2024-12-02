package br.com.fiap.postech.techchallenge.infrastructure.client.mercadopago;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(url= "https://api.mercadopago.com/", name= "mercadopago")
public interface MercadopagoClient {

    @PostMapping("instore/orders/qr/seller/collectors/{user_id}/pos/{external_pos_id}/qrs")
    QrCodeOrderResponse createOrderQrCode(
            @RequestHeader("Authorization") String authorization,
            @PathVariable("user_id") String userId,
            @PathVariable("external_pos_id") String externalPosId,
            @RequestBody QrCodeOrderRequest object);

    @GetMapping("merchant_orders/{id}")
    PaymentResponse getPayment(
            @RequestHeader("Authorization") String authorization,
            @PathVariable("id") String merchantId);
}
