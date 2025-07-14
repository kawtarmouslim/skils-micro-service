package com.example.rendu.service.impl;


import com.example.rendu.clientFeign.ApprentClientFeign;
import com.example.rendu.clientFeign.BrefClient;
import com.example.rendu.clientFeign.CompetenceFeign;
import com.example.rendu.dto.ApprenantDTO;
import com.example.rendu.dto.BrefDto;
import com.example.rendu.dto.CompetenceDto;
import com.example.rendu.dto.RenduDTO;
import com.example.rendu.mapper.RenduMapper;
import com.example.rendu.model.Apprente;
import com.example.rendu.model.Bref;
import com.example.rendu.model.Rendu;
import com.example.rendu.repository.RenduRepository;
import com.example.rendu.service.RenduService;
import feign.FeignException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@AllArgsConstructor
@Service
public class RenduServiceImpl implements RenduService {

    private final RenduRepository repository;
    @Qualifier("renduMapperImpl")
    private final RenduMapper mapper;
    private final ApprentClientFeign apprentClientFeign;
    private  final BrefClient brefClient;
    private  final CompetenceFeign competenceClient;


    @Override
    public RenduDTO save(RenduDTO renduDTO) {
        try {
            ApprenantDTO apprenant = apprentClientFeign.getById(renduDTO.getIdApprent());
        } catch (FeignException.NotFound e) {
            throw new RuntimeException("Apprenant non trouvé avec l'ID : " + renduDTO.getIdApprent());
        }

        try {
            BrefDto brefDto = brefClient.getBref(renduDTO.getIdBref());
        } catch (FeignException.NotFound e) {
            throw new RuntimeException("Bref non trouvé avec l'ID : " + renduDTO.getIdBref());
        }
        try {
            CompetenceDto competenceDto = competenceClient.getCompetenceById(renduDTO.getIdCompetence());
        } catch (FeignException.NotFound e) {
            throw new RuntimeException("competence non trouvé avec l'ID : " + renduDTO.getIdCompetence());
        }


        Rendu rendu = mapper.toEntity(renduDTO);
        rendu.setApprenantId(renduDTO.getIdApprent());
        rendu.setIdBref(renduDTO.getIdBref());
        rendu.setIdCompetence(renduDTO.getIdCompetence());

        return mapper.toDTO(repository.save(rendu));
    }



    @Override
    public List<RenduDTO> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RenduDTO getById(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElse(null);
    }


}

