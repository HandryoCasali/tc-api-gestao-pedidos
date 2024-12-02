package br.com.fiap.postech.techchallenge.core.domain;

import br.com.fiap.postech.techchallenge.core.domain.enums.ProductCategory;
import br.com.fiap.postech.techchallenge.application.dto.product.UpdateProductDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.Duration;

@Data
@EqualsAndHashCode(callSuper = true)
public class Product extends BaseDomain {

    private String name;
    private String description;
    private BigDecimal price = BigDecimal.ZERO;
    private Double discountPercent = 0.0;
    private Duration estimatedTime;
    private ProductCategory productCategory;

    public void update(UpdateProductDto productDto) {
        this.name = productDto.getName();
        this.description = productDto.getDescription();
        this.price = productDto.getPrice();
        this.discountPercent = productDto.getDiscountPercent();
    }

    public BigDecimal getPriceDiscounted() {
        return price.multiply(BigDecimal.valueOf(1 - discountPercent));
    }

}
