package br.com.fiap.postech.techchallenge.core.usecase.addon;

import br.com.fiap.postech.techchallenge.application.interfaces.repository.IAddonRepository;
import br.com.fiap.postech.techchallenge.application.dto.addon.AddonDto;
import br.com.fiap.postech.techchallenge.application.dto.addon.CreateAddonDto;
import br.com.fiap.postech.techchallenge.application.mapper.IAddonMapper;
import org.springframework.stereotype.Service;

@Service
public class CreateAddonUseCase {
    private final IAddonRepository addonRepository;
    private final IAddonMapper mapper;

    public CreateAddonUseCase(IAddonRepository addonRepository, IAddonMapper mapper) {
        this.addonRepository = addonRepository;
        this.mapper = mapper;
    }

    public AddonDto create(CreateAddonDto addon) {
        var domain = mapper.toDomain(addon);
        var domainSaved = addonRepository.save(domain);
        return mapper.toAddonDto(domainSaved);
    }
}
