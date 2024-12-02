package br.com.fiap.postech.techchallenge.infrastructure.jpa.repositories;

import br.com.fiap.postech.techchallenge.infrastructure.jpa.entities.EntityBase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IJpaRepositoryBase<T extends EntityBase> extends JpaRepository<T, Long> {

}
