package br.com.fiap.postech.techchallenge.application.interfaces.repository;

import br.com.fiap.postech.techchallenge.core.domain.Product;
import br.com.fiap.postech.techchallenge.core.domain.enums.ProductCategory;

import java.util.List;

public interface IProductRepository extends IRepositoryBase<Product>{
    List<Product> findAllByProductCategory(ProductCategory productCategory);
}
