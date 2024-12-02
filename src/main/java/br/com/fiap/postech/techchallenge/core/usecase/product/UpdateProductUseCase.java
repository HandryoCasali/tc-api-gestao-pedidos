package br.com.fiap.postech.techchallenge.core.usecase.product;

import br.com.fiap.postech.techchallenge.application.interfaces.repository.IProductRepository;
import br.com.fiap.postech.techchallenge.core.exception.EntityNotFoundException;
import br.com.fiap.postech.techchallenge.application.mapper.IProductMapper;
import br.com.fiap.postech.techchallenge.application.dto.product.ProductDto;
import br.com.fiap.postech.techchallenge.application.dto.product.UpdateProductDto;
import org.springframework.stereotype.Service;

@Service
public class UpdateProductUseCase {

    private final IProductRepository productRepository;
    private final IProductMapper mapper;

    public UpdateProductUseCase(IProductRepository productRepository, IProductMapper mapper) {
        this.productRepository = productRepository;
        this.mapper = mapper;
    }

    public ProductDto update(Long idProduct, UpdateProductDto productDto) throws EntityNotFoundException {
        var entity = productRepository.findById(idProduct);
        entity.update(productDto);
        productRepository.save(entity);
        return mapper.toProductDto(entity);
    }
}
