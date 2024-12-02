package br.com.fiap.postech.techchallenge.application.dto.order;

import br.com.fiap.postech.techchallenge.application.dto.CreateComboDto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class CreateOrderDto {

    @NotEmpty
    @NotNull
    private List<CreateComboDto> combos;
    private Long customerId;
}
