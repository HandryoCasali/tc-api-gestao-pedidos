package br.com.fiap.postech.techchallenge.infrastructure.repositorio;

import br.com.fiap.postech.techchallenge.core.domain.Addon;
import br.com.fiap.postech.techchallenge.core.domain.enums.ProductCategory;
import br.com.fiap.postech.techchallenge.application.interfaces.repository.IAddonRepository;
import br.com.fiap.postech.techchallenge.application.mapper.IBaseDomainMapper;
import br.com.fiap.postech.techchallenge.infrastructure.jpa.entities.AddonEntity;
import br.com.fiap.postech.techchallenge.infrastructure.jpa.repositories.IAddonJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AddonRepository extends RepositoryBase<Addon, AddonEntity> implements IAddonRepository {

    private final IAddonJpaRepository repository;
    private final IBaseDomainMapper<Addon, AddonEntity> mapper;

    public AddonRepository(IAddonJpaRepository repository, IBaseDomainMapper<Addon, AddonEntity> mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<Addon> findAllByProductCategory(ProductCategory productCategory) {
        var entities = repository.findAllByIsActiveTrueAndProductCategory(productCategory);
        return mapper.toDomains(entities);
    }
}
