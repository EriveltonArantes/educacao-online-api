package com.educacaoonlineapi.mapper;

import com.educacaoonlineapi.dto.CursoRequestDTO;
import com.educacaoonlineapi.dto.CursoResponseDTO;
import com.educacaoonlineapi.model.Curso;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CursoMapper {

    @Mapping(target = "instrutor", ignore = true)
    Curso toEntity(CursoRequestDTO dto);

    @Mapping(target = "instrutorId", source = "instrutor.id")
    CursoResponseDTO toResponseDTO(Curso entity);
}
