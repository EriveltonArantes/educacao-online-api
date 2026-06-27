package com.educacaoonlineapi.mapper;

import com.educacaoonlineapi.dto.MatriculaRequestDTO;
import com.educacaoonlineapi.dto.MatriculaResponseDTO;
import com.educacaoonlineapi.model.Matricula;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MatriculaMapper {

    @Mapping(target = "curso", ignore = true)
    Matricula toEntity(MatriculaRequestDTO dto);

    @Mapping(target = "cursoId", source = "curso.id")
    MatriculaResponseDTO toResponseDTO(Matricula entity);
}
