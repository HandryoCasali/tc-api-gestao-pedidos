package br.com.fiap.postech.techchallenge.application.dto.combo;

import br.com.fiap.postech.techchallenge.application.dto.addon.AddonDto;
import br.com.fiap.postech.techchallenge.application.dto.product.ProductDto;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class ComboDto {
    private ProductDto product;
    private List<AddonDto> addons;
    private BigDecimal totalPrice;
}
