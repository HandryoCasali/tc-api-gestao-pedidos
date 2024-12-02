package br.com.fiap.postech.techchallenge.core.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum PaymentStatus {
    PENDING("Pending"),
    FINISHED("Finished");

    private final String displayName;

    PaymentStatus(String displayName){
        this.displayName = displayName;
    }

    @JsonValue
    public String getDisplayName() {
        return displayName;
    }

    @JsonCreator
    public static PaymentStatus fromDisplayName(String displayName){
        for (PaymentStatus category : PaymentStatus.values()) {
            if (category.getDisplayName().equals(displayName) || category.name().equalsIgnoreCase(displayName)) {
                return category;
            }
        }
        throw new IllegalArgumentException("Status do pagamento: " + displayName + " não encontrada!");
    }
}
