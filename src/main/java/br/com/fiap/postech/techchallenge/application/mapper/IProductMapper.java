package br.com.fiap.postech.techchallenge.application.mapper;

import br.com.fiap.postech.techchallenge.core.domain.Product;
import br.com.fiap.postech.techchallenge.infrastructure.jpa.entities.ProductEntity;
import br.com.fiap.postech.techchallenge.application.dto.product.CreateProductDto;
import br.com.fiap.postech.techchallenge.application.dto.product.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = IProductCategoryMapper.class)
public interface IProductMapper extends IBaseDomainMapper<Product, ProductEntity> {

    @Mapping(target = "productCategoryName", source = "productCategory")
    ProductDto toProductDto(Product product);

    @Mapping(target = "estimatedTime", ignore = true)
    Product toProduct(CreateProductDto dto);

    List<ProductDto> toProductsDto(List<Product> products);

}
