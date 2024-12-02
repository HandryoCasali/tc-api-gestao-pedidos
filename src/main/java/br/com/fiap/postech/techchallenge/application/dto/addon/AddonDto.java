package br.com.fiap.postech.techchallenge.application.dto.addon;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class AddonDto {
    private Long id;
    private String name;
    private BigDecimal price;
    private Double discountPercent;
    private String productCategoryName;
}
