package br.com.fiap.postech.techchallenge.application.mapper;

import br.com.fiap.postech.techchallenge.core.domain.Combo;
import br.com.fiap.postech.techchallenge.infrastructure.jpa.entities.ComboEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IComboMapper extends IBaseDomainMapper<Combo, ComboEntity> {
}
