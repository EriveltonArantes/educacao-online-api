package com.educacaoonlineapi.controller;

import com.educacaoonlineapi.dto.AulaRequestDTO;
import com.educacaoonlineapi.dto.AulaResponseDTO;
import com.educacaoonlineapi.service.AulaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Aula", description = "Gerenciamento de aulas")
@RestController
@RequestMapping("/api/aulas")
public class AulaController {

    @Autowired
    private AulaService service;

    @Operation(summary = "Listar todos os Aula")
    @GetMapping
    public List<AulaResponseDTO> listar(@RequestParam(required = false) String titulo, @RequestParam(required = false) Long cursoId) {
        List<AulaResponseDTO> resultado = service.listar();
        if (titulo != null && !titulo.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getTitulo() != null &&
                item.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        if (cursoId != null) {
            resultado = resultado.stream().filter(item -> cursoId.equals(item.getCursoId())).collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Aula por ID")
    @GetMapping("/{id}")
    public AulaResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Aula")
    @PostMapping
    public ResponseEntity<AulaResponseDTO> criar(@Valid @RequestBody AulaRequestDTO aula) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(aula));
    }

    @Operation(summary = "Atualizar Aula")
    @PutMapping("/{id}")
    public AulaResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody AulaRequestDTO aula) {
        return service.atualizar(id, aula);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Aula")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
