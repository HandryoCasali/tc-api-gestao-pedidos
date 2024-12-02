package br.com.fiap.postech.techchallenge.infrastructure.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CustomErrorResponse {
    private Integer errorCode;
    private String message;
    private LocalDateTime timestamp;

    public CustomErrorResponse(Integer errorCode, String message){
        this.errorCode = errorCode;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }
}
