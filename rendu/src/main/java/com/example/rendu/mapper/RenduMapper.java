package com.example.rendu.mapper;



import com.example.rendu.dto.RenduDTO;
import com.example.rendu.model.Rendu;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RenduMapper {
    RenduDTO toDTO(Rendu rendu);
    Rendu toEntity(RenduDTO dto);
    List<RenduDTO> toDTOs(List<Rendu> rendus);
}

