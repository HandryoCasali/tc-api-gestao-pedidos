package br.com.fiap.postech.techchallenge.core.usecase.product;

import br.com.fiap.postech.techchallenge.application.interfaces.repository.IProductRepository;
import br.com.fiap.postech.techchallenge.application.mapper.IProductMapper;
import br.com.fiap.postech.techchallenge.application.dto.product.CreateProductDto;
import br.com.fiap.postech.techchallenge.application.dto.product.ProductDto;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class CreateProductUseCase {
    private final IProductRepository productRepository;
    private final IProductMapper mapper;

    public CreateProductUseCase(IProductRepository productRepository, IProductMapper mapper) {
        this.productRepository = productRepository;
        this.mapper = mapper;
    }

    public ProductDto create(CreateProductDto productDto){
        var product = mapper.toProduct(productDto);
        product.setEstimatedTime(Duration.ofMinutes(productDto.getEstimatedTime()));
        var productSaved = productRepository.save(product);
        return mapper.toProductDto(productSaved);
    }
}
