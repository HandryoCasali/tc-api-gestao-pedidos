package br.com.fiap.postech.techchallenge.infrastructure.jpa.repositories;

import br.com.fiap.postech.techchallenge.core.domain.enums.ProductCategory;
import br.com.fiap.postech.techchallenge.infrastructure.jpa.entities.AddonEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;

import java.util.List;

public interface IAddonJpaRepository extends IJpaRepositoryBase<AddonEntity> {
    List<AddonEntity> findAllByIsActiveTrueAndProductCategory(ProductCategory productCategory);

    @Override
    @Modifying
    @Query("UPDATE AddonEntity a SET a.isActive = false WHERE a.id = :id")
    void deleteById(@NonNull @Param("id") Long id);

    List<AddonEntity> findAllByIsActiveFalse();
}
