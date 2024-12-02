package br.com.fiap.postech.techchallenge.application.dto.addon;

import br.com.fiap.postech.techchallenge.core.domain.enums.ProductCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class CreateAddonDto{
    @NotBlank
    private String name;
    @NotNull
    private BigDecimal price;
    @NotNull
    private ProductCategory productCategory;
    @NotNull
    private Double discountPercent;
}
