package br.com.fiap.postech.techchallenge.infrastructure.jpa.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "combos")
public class ComboEntity extends EntityBase{
    @ManyToOne
    private ProductEntity product;

    @ManyToMany
    private List<AddonEntity> addons = new ArrayList<>();
    private BigDecimal totalPrice = BigDecimal.ZERO;
}
