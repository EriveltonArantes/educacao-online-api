package com.educacaoonlineapi.controller;

import com.educacaoonlineapi.dto.InstrutorRequestDTO;
import com.educacaoonlineapi.dto.InstrutorResponseDTO;
import com.educacaoonlineapi.service.InstrutorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Instrutor", description = "Gerenciamento de instrutors")
@RestController
@RequestMapping("/api/instrutors")
public class InstrutorController {

    @Autowired
    private InstrutorService service;

    @Operation(summary = "Listar todos os Instrutor")
    @GetMapping
    public List<InstrutorResponseDTO> listar(@RequestParam(required = false) String nome) {
        List<InstrutorResponseDTO> resultado = service.listar();
        if (nome != null && !nome.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getNome() != null &&
                item.getNome().toLowerCase().contains(nome.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Instrutor por ID")
    @GetMapping("/{id}")
    public InstrutorResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Instrutor")
    @PostMapping
    public ResponseEntity<InstrutorResponseDTO> criar(@Valid @RequestBody InstrutorRequestDTO instrutor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(instrutor));
    }

    @Operation(summary = "Atualizar Instrutor")
    @PutMapping("/{id}")
    public InstrutorResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody InstrutorRequestDTO instrutor) {
        return service.atualizar(id, instrutor);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Instrutor")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
