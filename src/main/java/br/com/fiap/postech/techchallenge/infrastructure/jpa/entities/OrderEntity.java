package br.com.fiap.postech.techchallenge.infrastructure.jpa.entities;


import br.com.fiap.postech.techchallenge.core.domain.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "orders")
public class OrderEntity extends EntityBase {
    @OneToMany(cascade = CascadeType.ALL)
    private List<ComboEntity> combos;
    @Column(nullable = false)
    private BigDecimal totalPrice;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    private LocalDateTime finishedTime;

    @ManyToOne
    @JoinColumn(nullable = false)
    private CustomerEntity customer;
}
