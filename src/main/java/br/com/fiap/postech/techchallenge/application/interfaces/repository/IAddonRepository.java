package br.com.fiap.postech.techchallenge.application.interfaces.repository;

import br.com.fiap.postech.techchallenge.core.domain.Addon;
import br.com.fiap.postech.techchallenge.core.domain.enums.ProductCategory;

import java.util.List;

public interface IAddonRepository extends IRepositoryBase<Addon> {
    List<Addon> findAllByProductCategory(ProductCategory productCategory);
}
