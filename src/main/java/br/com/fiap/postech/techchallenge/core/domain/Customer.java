package br.com.fiap.postech.techchallenge.core.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer extends BaseDomain {
    private String name;
    private String cpf;
    private String email;
}
