package br.com.fiap.postech.techchallenge.core.usecase.product;

import br.com.fiap.postech.techchallenge.application.interfaces.repository.IProductRepository;
import br.com.fiap.postech.techchallenge.core.domain.enums.ProductCategory;
import br.com.fiap.postech.techchallenge.application.mapper.IProductMapper;
import br.com.fiap.postech.techchallenge.application.dto.product.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllProductByProductCategoryUseCase {
    private final IProductRepository productRepository;
    private final IProductMapper mapper;

    public FindAllProductByProductCategoryUseCase(IProductRepository productRepository, IProductMapper mapper) {
        this.productRepository = productRepository;
        this.mapper = mapper;
    }

    public List<ProductDto> find(String name) {
        var entities = productRepository.findAllByProductCategory(ProductCategory.fromDisplayName(name));
        return mapper.toProductsDto(entities);
    }
}
