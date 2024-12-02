package br.com.fiap.postech.techchallenge.application.mapper;

import br.com.fiap.postech.techchallenge.core.domain.PaymentOrder;
import br.com.fiap.postech.techchallenge.infrastructure.jpa.entities.PaymentOrderEntity;
import br.com.fiap.postech.techchallenge.application.dto.payment.PaymentOrderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {IPaymentStatusMapper.class, IPaymentTypeMapper.class, IOrderMapper.class})
public interface IPaymentOrderMapper extends IBaseDomainMapper<PaymentOrder, PaymentOrderEntity> {

    @Mapping(target = "paymentStatusName", source = "paymentStatus")
    @Mapping(target = "paymentTypeName", source = "paymentType")
    PaymentOrderDTO toPaymentOrderDTO(PaymentOrder paymentOrder);

    List<PaymentOrderDTO> toPaymentOrderDTO(List<PaymentOrder> paymentOrder);

}
