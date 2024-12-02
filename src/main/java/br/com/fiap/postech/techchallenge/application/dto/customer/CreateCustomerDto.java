package br.com.fiap.postech.techchallenge.application.dto.customer;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCustomerDto {
    private String name;
    @NotBlank
    private String cpf;
    private String email;
}
