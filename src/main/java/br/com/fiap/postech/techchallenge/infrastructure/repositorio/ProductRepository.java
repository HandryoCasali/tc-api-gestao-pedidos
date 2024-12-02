package br.com.fiap.postech.techchallenge.infrastructure.repositorio;

import br.com.fiap.postech.techchallenge.application.interfaces.repository.IProductRepository;
import br.com.fiap.postech.techchallenge.core.domain.Product;
import br.com.fiap.postech.techchallenge.core.domain.enums.ProductCategory;
import br.com.fiap.postech.techchallenge.application.mapper.IProductMapper;
import br.com.fiap.postech.techchallenge.infrastructure.jpa.entities.ProductEntity;
import br.com.fiap.postech.techchallenge.infrastructure.jpa.repositories.IProductJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository extends RepositoryBase<Product, ProductEntity> implements IProductRepository {

    private final IProductJpaRepository repository;
    private final IProductMapper mapper;

    public ProductRepository(IProductJpaRepository repository, IProductMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<Product> findAllByProductCategory(ProductCategory productCategory) {
        var entities = repository.findAllByIsActiveTrueAndProductCategory(productCategory);
        return mapper.toDomains(entities);
    }

    @Override
    public void deleteById(Long id){
        repository.deleteById(id);
    }
}
