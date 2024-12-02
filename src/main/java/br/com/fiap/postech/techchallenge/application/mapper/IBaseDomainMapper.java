package br.com.fiap.postech.techchallenge.application.mapper;

import br.com.fiap.postech.techchallenge.core.domain.BaseDomain;
import br.com.fiap.postech.techchallenge.infrastructure.jpa.entities.EntityBase;

import java.util.List;

public interface IBaseDomainMapper<T extends BaseDomain, U extends EntityBase> {
     T toDomain(U entityBase);
     U toEntity(T domain);
     List<T> toDomains(List<U> entities);
}
