package br.com.fiap.postech.techchallenge.core.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ProductCategory {
    LANCHE("Lanche"),
    ACOMPANHAMENTO("Acompanhamento"),
    BEBIDAS("Bebidas"),
    SOBREMESA("Sobremesa");


    private final String displayName;

    ProductCategory(String displayName){
        this.displayName = displayName;
    }

    @JsonValue
    public String getDisplayName() {
        return displayName;
    }

    @JsonCreator
    public static ProductCategory fromDisplayName(String displayName){
        for (ProductCategory category : ProductCategory.values()) {
            if (category.getDisplayName().equals(displayName) || category.name().equalsIgnoreCase(displayName)) {
                return category;
            }
        }
        throw new IllegalArgumentException("Categoria: " + displayName + " não encontrada!");
    }
}
