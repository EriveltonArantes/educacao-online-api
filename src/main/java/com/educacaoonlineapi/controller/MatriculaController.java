package com.educacaoonlineapi.controller;

import com.educacaoonlineapi.dto.MatriculaRequestDTO;
import com.educacaoonlineapi.dto.MatriculaResponseDTO;
import com.educacaoonlineapi.service.MatriculaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Matricula", description = "Gerenciamento de matriculas")
@RestController
@RequestMapping("/api/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaService service;

    @Operation(summary = "Listar todos os Matricula")
    @GetMapping
    public List<MatriculaResponseDTO> listar(@RequestParam(required = false) String alunoNome, @RequestParam(required = false) Long cursoId) {
        List<MatriculaResponseDTO> resultado = service.listar();
        if (alunoNome != null && !alunoNome.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getAlunoNome() != null &&
                item.getAlunoNome().toLowerCase().contains(alunoNome.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        if (cursoId != null) {
            resultado = resultado.stream().filter(item -> cursoId.equals(item.getCursoId())).collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Matricula por ID")
    @GetMapping("/{id}")
    public MatriculaResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Matricula")
    @PostMapping
    public ResponseEntity<MatriculaResponseDTO> criar(@Valid @RequestBody MatriculaRequestDTO matricula) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(matricula));
    }

    @Operation(summary = "Atualizar Matricula")
    @PutMapping("/{id}")
    public MatriculaResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody MatriculaRequestDTO matricula) {
        return service.atualizar(id, matricula);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Matricula")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
