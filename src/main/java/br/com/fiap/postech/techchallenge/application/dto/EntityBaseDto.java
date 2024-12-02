package br.com.fiap.postech.techchallenge.core.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class EntityBaseDto {
    protected Long id;
    protected Date creationTime;
}
