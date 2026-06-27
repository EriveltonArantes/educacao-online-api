package com.educacaoonlineapi.service;

import com.educacaoonlineapi.dto.AulaRequestDTO;
import com.educacaoonlineapi.dto.AulaResponseDTO;
import com.educacaoonlineapi.exception.ResourceNotFoundException;
import com.educacaoonlineapi.mapper.AulaMapper;
import com.educacaoonlineapi.model.Aula;
import com.educacaoonlineapi.repository.AulaRepository;
import com.educacaoonlineapi.repository.CursoRepository;
import com.educacaoonlineapi.model.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AulaService {

    @Autowired
    private AulaRepository repository;

    @Autowired
    private AulaMapper mapper;

    @Autowired
    private CursoRepository cursoRepository;

    @Transactional(readOnly = true)
    public List<AulaResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public AulaResponseDTO buscar(Long id) {
        Aula entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Aula não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public AulaResponseDTO criar(AulaRequestDTO dto) {
        Aula entity = mapper.toEntity(dto);
        Curso curso = cursoRepository.findById(dto.getCursoId())
            .orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado com id: " + dto.getCursoId()));
        entity.setCurso(curso);
        Aula salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public AulaResponseDTO atualizar(Long id, AulaRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Aula não encontrado com id: " + id);
        }
        Aula entity = mapper.toEntity(dto);
        entity.setId(id);
        Curso curso = cursoRepository.findById(dto.getCursoId())
            .orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado com id: " + dto.getCursoId()));
        entity.setCurso(curso);
        Aula salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Aula não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
