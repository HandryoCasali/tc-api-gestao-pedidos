package br.com.fiap.postech.techchallenge.infrastructure.exception.validationError;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FieldError {

    private String fieldName;
    private String message;
}