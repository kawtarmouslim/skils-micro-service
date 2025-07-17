package com.example.rendu.mapper;

import com.example.rendu.dto.RenduDTO;
import com.example.rendu.model.Rendu;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-17T11:27:31+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class RenduMapperImpl implements RenduMapper {

    @Override
    public RenduDTO toDTO(Rendu rendu) {
        if ( rendu == null ) {
            return null;
        }

        RenduDTO renduDTO = new RenduDTO();

        renduDTO.setIdApprent( rendu.getApprenantId() );
        renduDTO.setIdRendu( rendu.getIdRendu() );
        renduDTO.setLienRendu( rendu.getLienRendu() );
        renduDTO.setDateRendu( rendu.getDateRendu() );
        List<Long> list = rendu.getId();
        if ( list != null ) {
            renduDTO.setId( new ArrayList<Long>( list ) );
        }
        renduDTO.setIdBref( rendu.getIdBref() );

        return renduDTO;
    }

    @Override
    public Rendu toEntity(RenduDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Rendu rendu = new Rendu();

        rendu.setApprenantId( dto.getIdApprent() );
        rendu.setIdRendu( dto.getIdRendu() );
        rendu.setLienRendu( dto.getLienRendu() );
        rendu.setDateRendu( dto.getDateRendu() );
        List<Long> list = dto.getId();
        if ( list != null ) {
            rendu.setId( new ArrayList<Long>( list ) );
        }
        rendu.setIdBref( dto.getIdBref() );

        return rendu;
    }

    @Override
    public List<RenduDTO> toDTOs(List<Rendu> rendus) {
        if ( rendus == null ) {
            return null;
        }

        List<RenduDTO> list = new ArrayList<RenduDTO>( rendus.size() );
        for ( Rendu rendu : rendus ) {
            list.add( toDTO( rendu ) );
        }

        return list;
    }
}
