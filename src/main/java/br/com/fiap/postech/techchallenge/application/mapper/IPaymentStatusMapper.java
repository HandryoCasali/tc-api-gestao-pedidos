package br.com.fiap.postech.techchallenge.application.mapper;

import br.com.fiap.postech.techchallenge.core.domain.enums.PaymentStatus;
import br.com.fiap.postech.techchallenge.core.domain.enums.PaymentType;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface IPaymentStatusMapper {

    IPaymentStatusMapper INSTANCE = Mappers.getMapper(IPaymentStatusMapper.class);

    default String map(PaymentType paymentType)
    {
        return paymentType == null ? null : paymentType.name();
    }
    default PaymentStatus map(String PaymentStatusName) {
        return PaymentStatusName == null ? null : PaymentStatus.valueOf(PaymentStatusName);
    }

}
