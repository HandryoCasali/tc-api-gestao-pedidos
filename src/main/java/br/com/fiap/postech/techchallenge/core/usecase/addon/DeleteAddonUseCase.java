package br.com.fiap.postech.techchallenge.core.usecase.addon;

import br.com.fiap.postech.techchallenge.application.interfaces.repository.IAddonRepository;
import br.com.fiap.postech.techchallenge.core.exception.EntityNotFoundException;
import br.com.fiap.postech.techchallenge.application.mapper.IAddonMapper;
import org.springframework.stereotype.Service;


@Service
public class DeleteAddonUseCase {

    private final IAddonRepository addonRepository;

    public DeleteAddonUseCase(IAddonRepository addonRepository, IAddonMapper mapper) {
        this.addonRepository = addonRepository;
    }

    public void delete(Long id) throws EntityNotFoundException {
        if(!addonRepository.existsById(id)) throw new EntityNotFoundException("Adicional não encontrado!");
        addonRepository.deleteById(id);
    }
}
