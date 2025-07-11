package com.example.rendu.mapper;



import com.example.rendu.dto.RenduDTO;
import com.example.rendu.model.Rendu;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RenduMapper {
    @Mapping(source = "apprenantId", target = "idApprent")

    RenduDTO toDTO(Rendu rendu);
    @Mapping(source = "idApprent", target = "apprenantId")

    Rendu toEntity(RenduDTO dto);
    List<RenduDTO> toDTOs(List<Rendu> rendus);
}

