package br.com.fiap.postech.techchallenge.infrastructure.repositorio;

import br.com.fiap.postech.techchallenge.core.domain.BaseDomain;
import br.com.fiap.postech.techchallenge.application.mapper.IBaseDomainMapper;
import br.com.fiap.postech.techchallenge.infrastructure.jpa.entities.EntityBase;
import br.com.fiap.postech.techchallenge.application.interfaces.repository.IRepositoryBase;
import br.com.fiap.postech.techchallenge.infrastructure.jpa.repositories.IJpaRepositoryBase;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class RepositoryBase<T extends BaseDomain, U extends EntityBase> implements IRepositoryBase<T> {

    protected final IJpaRepositoryBase<U> repository;
    protected final IBaseDomainMapper<T, U> mapper;

    @Transactional
    @Override
    public T save(T domain) {
        U entity = mapper.toEntity(domain);
        U saveEntity = repository.save(entity);
        return mapper.toDomain(saveEntity);
    }

    @Override
    public void delete(T domain) {
        U entity = mapper.toEntity(domain);
        repository.delete(entity);
    }

    @Override
    public T findById(Long id) {
        Optional<U> optEntity = repository.findById(id);
        U entity = null;
        if(optEntity.isPresent())
            entity = optEntity.get();
        return mapper.toDomain(entity);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }
}
