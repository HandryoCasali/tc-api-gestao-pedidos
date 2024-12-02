package br.com.fiap.postech.techchallenge.infrastructure.exception.validationError;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class ValidationError extends StandardError{
    private final List<FieldError> errors = new ArrayList<>();

    public ValidationError(LocalDateTime timestamp, String path, Integer status, String error, String message) {
        super(timestamp, path, status, error, message);
    }

    public void addError(String fieldName, String message) {
        this.errors.add(new FieldError(fieldName, message));
    }
}
