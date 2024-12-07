package br.com.fiap.postech.techchallenge.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class EntityBaseDto {
    protected Long id;
    protected Date creationTime;
}
