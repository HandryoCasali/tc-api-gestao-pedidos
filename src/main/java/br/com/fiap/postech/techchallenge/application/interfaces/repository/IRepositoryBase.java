package br.com.fiap.postech.techchallenge.application.interfaces.repository;

import br.com.fiap.postech.techchallenge.core.domain.BaseDomain;
import br.com.fiap.postech.techchallenge.core.exception.EntityNotFoundException;

public interface IRepositoryBase<T extends BaseDomain> {

    T save(T domain);
    void delete(T domain);
    T findById(Long id) throws EntityNotFoundException;
    void deleteById(Long id);
    boolean existsById(Long id);
}
