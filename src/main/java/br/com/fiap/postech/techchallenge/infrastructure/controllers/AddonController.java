package br.com.fiap.postech.techchallenge.infrastructure.controllers;

import br.com.fiap.postech.techchallenge.core.usecase.addon.CreateAddonUseCase;
import br.com.fiap.postech.techchallenge.core.usecase.addon.DeleteAddonUseCase;
import br.com.fiap.postech.techchallenge.core.usecase.addon.FindAllAddonsByProductCategoryUseCase;
import br.com.fiap.postech.techchallenge.core.usecase.addon.UpdateAddonUseCase;
import br.com.fiap.postech.techchallenge.core.exception.EntityNotFoundException;
import br.com.fiap.postech.techchallenge.application.dto.addon.AddonDto;
import br.com.fiap.postech.techchallenge.application.dto.addon.CreateAddonDto;
import br.com.fiap.postech.techchallenge.application.dto.addon.UpdateAddonDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/addon")
public class AddonController {

    private final CreateAddonUseCase createAddonUseCase;
    private final FindAllAddonsByProductCategoryUseCase findAllAddonsByProductCategoryUseCase;
    private final UpdateAddonUseCase updateAddonUseCase;
    private final DeleteAddonUseCase deleteAddonUseCase;

    @GetMapping
    public ResponseEntity<List<AddonDto>> listAllByProductCategory(@RequestParam String categoryName){
        var response = findAllAddonsByProductCategoryUseCase.find(categoryName);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<AddonDto> create(@RequestBody @Valid CreateAddonDto dto){
        var response = createAddonUseCase.create(dto);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddonDto> update(@PathVariable Long id, @RequestBody @Valid UpdateAddonDto dto) throws EntityNotFoundException {
        var response = updateAddonUseCase.update(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws EntityNotFoundException {
        deleteAddonUseCase.delete(id);
        return ResponseEntity.ok().build();
    }
}
