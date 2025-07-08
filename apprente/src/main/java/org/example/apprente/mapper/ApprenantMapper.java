package org.example.apprente.mapper;


import org.example.apprente.dto.ApprenantDTO;
import org.example.apprente.model.Apprenant;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ApprenantMapper {
    ApprenantDTO toDTO(Apprenant apprenant);
    Apprenant toEntity(ApprenantDTO dto);
    List<ApprenantDTO> toDTOs(List<Apprenant> list);
}

