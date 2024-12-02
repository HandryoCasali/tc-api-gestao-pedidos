package br.com.fiap.postech.techchallenge.infrastructure.controllers;

import br.com.fiap.postech.techchallenge.core.domain.enums.OrderStatus;
import br.com.fiap.postech.techchallenge.core.usecase.order.*;
import br.com.fiap.postech.techchallenge.core.exception.EntityNotFoundException;
import br.com.fiap.postech.techchallenge.application.dto.order.CreateOrderDto;
import br.com.fiap.postech.techchallenge.application.dto.order.DetailsOrderDto;
import br.com.fiap.postech.techchallenge.application.dto.order.OrderDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/order")
public class OrderController {
    private final FindAllOrdersByCustomerUseCase findAllOrdersByCustomerUseCase;
    private final FindAllOrdersByStatusUseCase findAllOrdersByStatusUseCase;
    private final FindAllOrdersUseCase findAllOrdersUseCase;
    private final UpdateOrderUseCase updateOrderUseCase;
    private final FindOrderByIdUseCase findOrderByIdUseCase;
    private final CreateOrderUseCase createOrderUseCase;

    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrdersByCostumer(@RequestParam String cpf){
        return ResponseEntity.ok(findAllOrdersByCustomerUseCase.find(cpf));
    }

    @GetMapping("/status/{orderStatus}")
    public ResponseEntity<List<DetailsOrderDto>> getAllOrdersByStatus(@PathVariable OrderStatus orderStatus) throws EntityNotFoundException{
        var response = findAllOrdersByStatusUseCase.find(orderStatus);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/allStatus")
    public ResponseEntity<List<DetailsOrderDto>> getAllOrders() throws EntityNotFoundException{
        var response = findAllOrdersUseCase.findAll();
        return ResponseEntity.ok(response);
    }
    @PutMapping("/{id}/{update}")
    public ResponseEntity<OrderDto> update(@RequestParam("id") Long id, @RequestParam("orderStatus") OrderStatus orderStatus) throws EntityNotFoundException {
        var dto = updateOrderUseCase.update(id, orderStatus);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailsOrderDto> getOrderById(@PathVariable Long id) throws EntityNotFoundException {
        return ResponseEntity.ok(findOrderByIdUseCase.find(id));
    }

    @PostMapping
    public ResponseEntity<OrderDto> create(@RequestBody @Valid CreateOrderDto orderDto) throws EntityNotFoundException {
        var order = createOrderUseCase.create(orderDto);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }
}
