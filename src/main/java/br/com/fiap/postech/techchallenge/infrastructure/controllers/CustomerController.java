package br.com.fiap.postech.techchallenge.infrastructure.controllers;

import br.com.fiap.postech.techchallenge.core.usecase.customer.CreateCustomerUseCase;
import br.com.fiap.postech.techchallenge.core.usecase.customer.FindCustomerByCpfUseCase;
import br.com.fiap.postech.techchallenge.core.exception.EntityNotFoundException;
import br.com.fiap.postech.techchallenge.application.dto.customer.CreateCustomerDto;
import br.com.fiap.postech.techchallenge.application.dto.customer.CustomerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CreateCustomerUseCase createCustomerUseCase;
    private final FindCustomerByCpfUseCase findCustomerByCpfUseCase;

    @GetMapping("/{cpf}")
    public ResponseEntity<CustomerDto> getByCpf(@PathVariable String cpf) throws EntityNotFoundException {
        return ResponseEntity.ok(findCustomerByCpfUseCase.find(cpf));
    }

    @PostMapping
    public ResponseEntity<CustomerDto> create(@RequestBody CreateCustomerDto dto) throws EntityNotFoundException {
        var saved = createCustomerUseCase.create(dto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
}
