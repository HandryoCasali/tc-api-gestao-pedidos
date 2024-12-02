package br.com.fiap.postech.techchallenge.infrastructure.repositorio;

import br.com.fiap.postech.techchallenge.application.interfaces.repository.IComboRepository;
import br.com.fiap.postech.techchallenge.core.domain.Combo;
import br.com.fiap.postech.techchallenge.application.mapper.IBaseDomainMapper;
import br.com.fiap.postech.techchallenge.infrastructure.jpa.entities.ComboEntity;
import br.com.fiap.postech.techchallenge.infrastructure.jpa.repositories.IJpaRepositoryBase;
import org.springframework.stereotype.Repository;

@Repository
public class ComboRepository extends RepositoryBase<Combo, ComboEntity> implements IComboRepository {

    public ComboRepository(IJpaRepositoryBase<ComboEntity> repository, IBaseDomainMapper<Combo, ComboEntity> mapper) {
        super(repository, mapper);
    }
}
