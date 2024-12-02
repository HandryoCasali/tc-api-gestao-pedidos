package br.com.fiap.postech.techchallenge.infrastructure.repositorio;

import br.com.fiap.postech.techchallenge.core.domain.PaymentOrder;
import br.com.fiap.postech.techchallenge.core.domain.enums.PaymentStatus;
import br.com.fiap.postech.techchallenge.application.interfaces.repository.IPaymentOrderRepository;
import br.com.fiap.postech.techchallenge.application.mapper.IPaymentOrderMapper;
import br.com.fiap.postech.techchallenge.infrastructure.jpa.entities.PaymentOrderEntity;
import br.com.fiap.postech.techchallenge.infrastructure.jpa.repositories.IPaymentOrderJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PaymentOrderRepository extends RepositoryBase<PaymentOrder, PaymentOrderEntity> implements IPaymentOrderRepository {

    private final IPaymentOrderJpaRepository repository;
    private final IPaymentOrderMapper mapper;

    public PaymentOrderRepository(IPaymentOrderJpaRepository repository, IPaymentOrderMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<PaymentOrder> findAllByPaymentStatusName(PaymentStatus paymentStatus) {
        var entities = repository.findAllByPaymentStatus(paymentStatus);
        return mapper.toDomains(entities);
    }

    @Override
    public PaymentOrder findByOrderId(Long orderId) {
        return mapper.toDomain(repository.findByOrderId(orderId));
    }

    @Override
    public void deleteById(Long id){
        repository.deleteById(id);
    }


}
