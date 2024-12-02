package br.com.fiap.postech.techchallenge.core.usecase.addon;

import br.com.fiap.postech.techchallenge.core.domain.enums.ProductCategory;
import br.com.fiap.postech.techchallenge.application.interfaces.repository.IAddonRepository;
import br.com.fiap.postech.techchallenge.application.mapper.IAddonMapper;
import br.com.fiap.postech.techchallenge.application.dto.addon.AddonDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllAddonsByProductCategoryUseCase {

    private final IAddonRepository addonRepository;
    private final IAddonMapper mapper;

    public FindAllAddonsByProductCategoryUseCase(IAddonRepository addonRepository, IAddonMapper mapper) {
        this.addonRepository = addonRepository;
        this.mapper = mapper;
    }

    public List<AddonDto> find(String productCategory) {
        var listAddon = addonRepository.findAllByProductCategory(ProductCategory.fromDisplayName(productCategory));
        return mapper.toAddonsDto(listAddon);
    }
}
