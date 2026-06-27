package com.educacaoonlineapi.mapper;

import com.educacaoonlineapi.dto.AulaRequestDTO;
import com.educacaoonlineapi.dto.AulaResponseDTO;
import com.educacaoonlineapi.model.Aula;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AulaMapper {

    @Mapping(target = "curso", ignore = true)
    Aula toEntity(AulaRequestDTO dto);

    @Mapping(target = "cursoId", source = "curso.id")
    AulaResponseDTO toResponseDTO(Aula entity);
}
