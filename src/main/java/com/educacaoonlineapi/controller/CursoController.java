package com.educacaoonlineapi.controller;

import com.educacaoonlineapi.dto.CursoRequestDTO;
import com.educacaoonlineapi.dto.CursoResponseDTO;
import com.educacaoonlineapi.service.CursoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Curso", description = "Gerenciamento de cursos")
@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private CursoService service;

    @Operation(summary = "Listar todos os Curso")
    @GetMapping
    public List<CursoResponseDTO> listar(@RequestParam(required = false) String titulo, @RequestParam(required = false) Long instrutorId) {
        List<CursoResponseDTO> resultado = service.listar();
        if (titulo != null && !titulo.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getTitulo() != null &&
                item.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        if (instrutorId != null) {
            resultado = resultado.stream().filter(item -> instrutorId.equals(item.getInstrutorId())).collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Curso por ID")
    @GetMapping("/{id}")
    public CursoResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Curso")
    @PostMapping
    public ResponseEntity<CursoResponseDTO> criar(@Valid @RequestBody CursoRequestDTO curso) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(curso));
    }

    @Operation(summary = "Atualizar Curso")
    @PutMapping("/{id}")
    public CursoResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody CursoRequestDTO curso) {
        return service.atualizar(id, curso);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Curso")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
