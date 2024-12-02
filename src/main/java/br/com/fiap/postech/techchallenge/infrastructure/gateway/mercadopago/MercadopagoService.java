package br.com.fiap.postech.techchallenge.infrastructure.gateway.mercadopago;

import br.com.fiap.postech.techchallenge.core.domain.Order;
import br.com.fiap.postech.techchallenge.core.interfaces.api.PaymentCreated;
import br.com.fiap.postech.techchallenge.infrastructure.client.mercadopago.MercadopagoClient;
import br.com.fiap.postech.techchallenge.core.interfaces.api.IPaymentApi;
import br.com.fiap.postech.techchallenge.infrastructure.client.mercadopago.PaymentResponse;
import br.com.fiap.postech.techchallenge.infrastructure.client.mercadopago.QrCodeOrderRequest;
import br.com.fiap.postech.techchallenge.infrastructure.client.mercadopago.QrCodeOrderResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MercadopagoService implements IPaymentApi {

    @Value("${mercadopago.access_token}")
    private String accessToken;
    @Value("${mercadopago.user_id}")
    private String userId;
    @Value("${mercadopago.external_pos_id}")
    private String externalPosId;
    @Value("${mercadopago.notification_url}")
    private String notificationUrl;
    @Value("${app-url}")
    private String appUrl;

    private final MercadopagoClient mercadopagoClient;

    @Override
    public PaymentCreated createPaymentQrCode(Order order) {

        QrCodeOrderResponse orderQrCode = mercadopagoClient.createOrderQrCode(getAuthorizationToken(), userId, externalPosId, createPaymentRequest(order));
        return new PaymentCreated(orderQrCode.getIn_store_order_id(), orderQrCode.getQr_data());
    }

    @Override
    public PaymentResponse getPayment(String paymentId){
        return mercadopagoClient.getPayment(getAuthorizationToken(), paymentId);
    }

    private QrCodeOrderRequest createPaymentRequest(Order order){
        String title = "Pedido nº: " + order.getId();
        return new QrCodeOrderRequest(order.getId().toString(),title, "", createNotificationUrl(), order.getTotalPrice().doubleValue(), createQrCodeItemsRequest(order));
    }

    private List<QrCodeOrderRequest.QrCodeItemRequest> createQrCodeItemsRequest(Order order) {
        return order.getCombos().stream().map(c->
            new QrCodeOrderRequest.QrCodeItemRequest(c.getProduct().getId().toString(),
                    c.getProduct().getProductCategory().getDisplayName(),
                    c.getProduct().getName(),
                    c.getProduct().getDescription(),
                    c.getTotalPrice().doubleValue(),
                    1,
                    c.getTotalPrice().doubleValue()))
                .toList();
    }

    private String createNotificationUrl(){
        log.info("Notificação url: " + appUrl + notificationUrl);
        return appUrl + notificationUrl;
    }

    private String getAuthorizationToken(){
        return "Bearer " + accessToken;
    }
}
