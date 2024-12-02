package br.com.fiap.postech.techchallenge.application.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class CreateComboDto {
    @NotNull
    private Long productId;
    private List<Long> addonsId;
}
