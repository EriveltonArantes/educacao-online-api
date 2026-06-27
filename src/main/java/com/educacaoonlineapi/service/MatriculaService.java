package com.educacaoonlineapi.service;

import com.educacaoonlineapi.dto.MatriculaRequestDTO;
import com.educacaoonlineapi.dto.MatriculaResponseDTO;
import com.educacaoonlineapi.exception.ResourceNotFoundException;
import com.educacaoonlineapi.mapper.MatriculaMapper;
import com.educacaoonlineapi.model.Matricula;
import com.educacaoonlineapi.repository.MatriculaRepository;
import com.educacaoonlineapi.repository.CursoRepository;
import com.educacaoonlineapi.model.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MatriculaService {

    @Autowired
    private MatriculaRepository repository;

    @Autowired
    private MatriculaMapper mapper;

    @Autowired
    private CursoRepository cursoRepository;

    @Transactional(readOnly = true)
    public List<MatriculaResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public MatriculaResponseDTO buscar(Long id) {
        Matricula entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Matricula não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public MatriculaResponseDTO criar(MatriculaRequestDTO dto) {
        Matricula entity = mapper.toEntity(dto);
        Curso curso = cursoRepository.findById(dto.getCursoId())
            .orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado com id: " + dto.getCursoId()));
        entity.setCurso(curso);
        Matricula salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public MatriculaResponseDTO atualizar(Long id, MatriculaRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Matricula não encontrado com id: " + id);
        }
        Matricula entity = mapper.toEntity(dto);
        entity.setId(id);
        Curso curso = cursoRepository.findById(dto.getCursoId())
            .orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado com id: " + dto.getCursoId()));
        entity.setCurso(curso);
        Matricula salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Matricula não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
