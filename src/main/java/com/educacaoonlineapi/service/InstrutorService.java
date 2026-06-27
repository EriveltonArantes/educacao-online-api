package com.educacaoonlineapi.service;

import com.educacaoonlineapi.dto.InstrutorRequestDTO;
import com.educacaoonlineapi.dto.InstrutorResponseDTO;
import com.educacaoonlineapi.exception.ResourceNotFoundException;
import com.educacaoonlineapi.mapper.InstrutorMapper;
import com.educacaoonlineapi.model.Instrutor;
import com.educacaoonlineapi.repository.InstrutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class InstrutorService {

    @Autowired
    private InstrutorRepository repository;

    @Autowired
    private InstrutorMapper mapper;

    @Transactional(readOnly = true)
    public List<InstrutorResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public InstrutorResponseDTO buscar(Long id) {
        Instrutor entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Instrutor não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public InstrutorResponseDTO criar(InstrutorRequestDTO dto) {
        Instrutor entity = mapper.toEntity(dto);
        Instrutor salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public InstrutorResponseDTO atualizar(Long id, InstrutorRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Instrutor não encontrado com id: " + id);
        }
        Instrutor entity = mapper.toEntity(dto);
        entity.setId(id);
        Instrutor salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Instrutor não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
