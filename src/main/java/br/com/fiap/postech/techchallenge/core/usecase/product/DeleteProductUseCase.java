package br.com.fiap.postech.techchallenge.core.usecase.product;

import br.com.fiap.postech.techchallenge.application.interfaces.repository.IProductRepository;
import br.com.fiap.postech.techchallenge.core.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DeleteProductUseCase {

    private final IProductRepository productRepository;

    public DeleteProductUseCase(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void delete(Long id) throws EntityNotFoundException {
        if(!productRepository.existsById(id)) throw new EntityNotFoundException("Produto não encontrado");
        productRepository.deleteById(id);
    }
}
