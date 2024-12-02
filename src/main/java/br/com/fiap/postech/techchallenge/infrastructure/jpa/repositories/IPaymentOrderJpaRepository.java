package br.com.fiap.postech.techchallenge.infrastructure.jpa.repositories;

import br.com.fiap.postech.techchallenge.core.domain.enums.PaymentStatus;
import br.com.fiap.postech.techchallenge.infrastructure.jpa.entities.PaymentOrderEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;

import java.util.List;

public interface IPaymentOrderJpaRepository extends IJpaRepositoryBase<PaymentOrderEntity> {

    List<PaymentOrderEntity> findAllByPaymentStatus(PaymentStatus paymentStatus);
    @Override
    @Modifying
    @Query("UPDATE PaymentOrderEntity p SET p.isActive = false WHERE p.id = :id")
    void deleteById(@NonNull @Param("id") Long id);

    PaymentOrderEntity findByOrderId(Long orderId);
}
