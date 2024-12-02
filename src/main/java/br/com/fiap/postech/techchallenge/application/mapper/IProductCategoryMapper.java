package br.com.fiap.postech.techchallenge.application.mapper;

import br.com.fiap.postech.techchallenge.core.domain.enums.ProductCategory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface IProductCategoryMapper {
    IProductCategoryMapper INSTANCE = Mappers.getMapper(IProductCategoryMapper.class);

    default String map(ProductCategory productCategory) {
        return productCategory != null ? productCategory.name() : null;
    }

    default ProductCategory map(String productCategoryName) {
        return productCategoryName != null ? ProductCategory.valueOf(productCategoryName) : null;
    }
}
