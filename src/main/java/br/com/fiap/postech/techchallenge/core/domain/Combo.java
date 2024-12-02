package br.com.fiap.postech.techchallenge.core.domain;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Combo extends BaseDomain {

    private Product product;
    private List<Addon> addons = new ArrayList<>();
    private BigDecimal totalPrice = BigDecimal.ZERO;

    public Combo(Product product){
        if(product == null) throw new IllegalArgumentException("Necessário um produto para o combo");
        this.product = product;
        increasePrice(product.getPriceDiscounted());
    }

    public void addAddon(Addon addon){
        boolean categoryEquals = product.getProductCategory().equals(addon.getProductCategory());
        if(!categoryEquals) throw new IllegalArgumentException(addon.getName() + " não pode ser ao produto " + product.getName());
        addons.add(addon);
        increasePrice(addon.getPriceDiscounted());
    }

    public void removeAddon(Addon addon){
        addons.remove(addon);
        decreasePrice(addon.getPriceDiscounted());
    }

    public BigDecimal getTotalPrice(){
        return BigDecimal.valueOf(totalPrice.doubleValue());
    }

    public List<Addon> getAddons(){
        return Collections.unmodifiableList(this.addons);
    }

    private void increasePrice(BigDecimal price){
        this.totalPrice = totalPrice.add(price);
    }

    private void decreasePrice(BigDecimal price){
        this.totalPrice = totalPrice.subtract(price);
    }

}
