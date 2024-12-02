package br.com.fiap.postech.techchallenge.infrastructure.jpa.entities;


import br.com.fiap.postech.techchallenge.core.domain.enums.ProductCategory;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "addons")
public class AddonEntity extends EntityBase {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ProductCategory productCategory;

    private BigDecimal discountPercent;
}
