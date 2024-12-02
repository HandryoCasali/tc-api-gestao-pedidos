package br.com.fiap.postech.techchallenge.infrastructure.jpa.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "customers")
public class CustomerEntity extends EntityBase{

    private String name;
    private String cpf;
    private String email;
}
