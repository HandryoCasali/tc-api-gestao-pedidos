package br.com.fiap.postech.techchallenge.core.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
public abstract class BaseDomain {
    protected Long id;
    protected LocalDateTime creationTime;
    protected Boolean isActive;
}
