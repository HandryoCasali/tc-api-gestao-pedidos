package br.com.fiap.postech.techchallenge.infrastructure.jpa.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class EntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected LocalDateTime creationTime;
    protected Boolean isActive;

    @PrePersist
    protected void onCreate() {
        this.creationTime = LocalDateTime.now();
        this.isActive = true;
    }
}
