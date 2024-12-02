package br.com.fiap.postech.techchallenge.application.mapper;

import br.com.fiap.postech.techchallenge.core.domain.enums.PaymentStatus;
import br.com.fiap.postech.techchallenge.core.domain.enums.PaymentType;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface IPaymentTypeMapper {

    IPaymentTypeMapper INSTANCE = Mappers.getMapper(IPaymentTypeMapper.class);

    default String map(PaymentStatus paymentStatus)
    {
        return paymentStatus == null ? null : paymentStatus.name();
    }
    default PaymentType map(String PaymentTypeName) {
        return PaymentTypeName == null ? null : PaymentType.valueOf(PaymentTypeName);
    }
}
