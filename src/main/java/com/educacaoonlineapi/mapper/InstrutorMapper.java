package com.educacaoonlineapi.mapper;

import com.educacaoonlineapi.dto.InstrutorRequestDTO;
import com.educacaoonlineapi.dto.InstrutorResponseDTO;
import com.educacaoonlineapi.model.Instrutor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InstrutorMapper {

    Instrutor toEntity(InstrutorRequestDTO dto);

    InstrutorResponseDTO toResponseDTO(Instrutor entity);
}
