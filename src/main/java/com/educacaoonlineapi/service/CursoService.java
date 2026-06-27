package com.educacaoonlineapi.service;

import com.educacaoonlineapi.dto.CursoRequestDTO;
import com.educacaoonlineapi.dto.CursoResponseDTO;
import com.educacaoonlineapi.exception.ResourceNotFoundException;
import com.educacaoonlineapi.mapper.CursoMapper;
import com.educacaoonlineapi.model.Curso;
import com.educacaoonlineapi.repository.CursoRepository;
import com.educacaoonlineapi.repository.InstrutorRepository;
import com.educacaoonlineapi.model.Instrutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CursoService {

    @Autowired
    private CursoRepository repository;

    @Autowired
    private CursoMapper mapper;

    @Autowired
    private InstrutorRepository instrutorRepository;

    @Transactional(readOnly = true)
    public List<CursoResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CursoResponseDTO buscar(Long id) {
        Curso entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public CursoResponseDTO criar(CursoRequestDTO dto) {
        Curso entity = mapper.toEntity(dto);
        Instrutor instrutor = instrutorRepository.findById(dto.getInstrutorId())
            .orElseThrow(() -> new ResourceNotFoundException("Instrutor não encontrado com id: " + dto.getInstrutorId()));
        entity.setInstrutor(instrutor);
        Curso salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public CursoResponseDTO atualizar(Long id, CursoRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Curso não encontrado com id: " + id);
        }
        Curso entity = mapper.toEntity(dto);
        entity.setId(id);
        Instrutor instrutor = instrutorRepository.findById(dto.getInstrutorId())
            .orElseThrow(() -> new ResourceNotFoundException("Instrutor não encontrado com id: " + dto.getInstrutorId()));
        entity.setInstrutor(instrutor);
        Curso salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Curso não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
