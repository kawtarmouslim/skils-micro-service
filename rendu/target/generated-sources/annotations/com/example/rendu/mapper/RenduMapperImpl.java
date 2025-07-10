package com.example.rendu.mapper;

import com.example.rendu.dto.RenduDTO;
import com.example.rendu.model.Rendu;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-10T13:42:28+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.6 (Oracle Corporation)"
)
@Component
public class RenduMapperImpl implements RenduMapper {

    @Override
    public RenduDTO toDTO(Rendu rendu) {
        if ( rendu == null ) {
            return null;
        }

        RenduDTO renduDTO = new RenduDTO();

        renduDTO.setId( rendu.getId() );
        renduDTO.setLienRendu( rendu.getLienRendu() );
        renduDTO.setDateRendu( rendu.getDateRendu() );

        return renduDTO;
    }

    @Override
    public Rendu toEntity(RenduDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Rendu rendu = new Rendu();

        rendu.setId( dto.getId() );
        rendu.setLienRendu( dto.getLienRendu() );
        rendu.setDateRendu( dto.getDateRendu() );

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
