package br.com.fiap.postech.techchallenge.application.dto.product;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Double discountPercent;
    private String productCategoryName;
}

