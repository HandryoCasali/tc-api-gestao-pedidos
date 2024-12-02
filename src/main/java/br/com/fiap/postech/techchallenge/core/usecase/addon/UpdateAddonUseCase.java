package br.com.fiap.postech.techchallenge.core.usecase.addon;

import br.com.fiap.postech.techchallenge.core.domain.Addon;
import br.com.fiap.postech.techchallenge.application.interfaces.repository.IAddonRepository;
import br.com.fiap.postech.techchallenge.core.exception.EntityNotFoundException;
import br.com.fiap.postech.techchallenge.application.mapper.IAddonMapper;
import br.com.fiap.postech.techchallenge.application.dto.addon.AddonDto;
import br.com.fiap.postech.techchallenge.application.dto.addon.UpdateAddonDto;
import org.springframework.stereotype.Service;

@Service
public class UpdateAddonUseCase {

    private final IAddonRepository addonRepository;
    private final IAddonMapper mapper;

    public UpdateAddonUseCase(IAddonRepository addonRepository, IAddonMapper mapper) {
        this.addonRepository = addonRepository;
        this.mapper = mapper;
    }

    public AddonDto update(Long id, UpdateAddonDto dto) throws EntityNotFoundException {
        Addon addon = addonRepository.findById(id);
        addon.update(dto.getName(), dto.getPrice(), dto.getDiscountPercent());
        Addon addonSaved = addonRepository.save(addon);
        return mapper.toAddonDto(addonSaved);
    }
}
