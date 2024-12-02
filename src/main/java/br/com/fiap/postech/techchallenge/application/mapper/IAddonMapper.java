package br.com.fiap.postech.techchallenge.application.mapper;

import br.com.fiap.postech.techchallenge.core.domain.Addon;
import br.com.fiap.postech.techchallenge.infrastructure.jpa.entities.AddonEntity;
import br.com.fiap.postech.techchallenge.application.dto.addon.AddonDto;
import br.com.fiap.postech.techchallenge.application.dto.addon.CreateAddonDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = IProductCategoryMapper.class)
public interface IAddonMapper extends IBaseDomainMapper<Addon, AddonEntity> {

    @Mapping(target = "productCategoryName", source = "productCategory")
    AddonDto toAddonDto(Addon addon);
    Addon toDomain(CreateAddonDto dto);
    List<AddonDto> toAddonsDto(List<Addon> domains);
}
