package com.educacaoonlineapi.controller;

import com.educacaoonlineapi.model.Instrutor;
import com.educacaoonlineapi.model.Curso;
import com.educacaoonlineapi.model.Matricula;
import com.educacaoonlineapi.model.Aula;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@Tag(name = "Dashboard", description = "KPIs e totais do sistema")
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private com.educacaoonlineapi.repository.InstrutorRepository instrutorRepository;

    @Autowired
    private com.educacaoonlineapi.repository.CursoRepository cursoRepository;

    @Autowired
    private com.educacaoonlineapi.repository.MatriculaRepository matriculaRepository;

    @Autowired
    private com.educacaoonlineapi.repository.AulaRepository aulaRepository;

    @Operation(summary = "Resumo com totais, somas e gráficos de status")
    @Transactional(readOnly = true)
    @GetMapping("/resumo")
    public Map<String, Object> resumo() {
        Map<String, Object> resumo = new LinkedHashMap<>();
        resumo.put("totalInstrutor", instrutorRepository.count());
        resumo.put("totalCurso", cursoRepository.count());
        resumo.put("somaPrecoCurso", cursoRepository.findAll().stream().filter(e -> e.getPreco() != null).mapToDouble(e -> e.getPreco()).sum());
        resumo.put("totalMatricula", matriculaRepository.count());
        resumo.put("somaValorPagoMatricula", matriculaRepository.findAll().stream().filter(e -> e.getValorPago() != null).mapToDouble(e -> e.getValorPago()).sum());
        resumo.put("graficoMatricula", matriculaRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        resumo.put("totalAula", aulaRepository.count());
        resumo.put("somaDuracaoAula", aulaRepository.findAll().stream().filter(e -> e.getDuracao() != null).mapToInt(e -> e.getDuracao()).sum());
        return resumo;
    }
}
