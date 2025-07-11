package com.example.rendu.service.impl;


import com.example.rendu.clientFeign.ApprentClientFeign;
import com.example.rendu.dto.ApprenantDTO;
import com.example.rendu.dto.RenduDTO;
import com.example.rendu.mapper.RenduMapper;
import com.example.rendu.model.Apprente;
import com.example.rendu.model.Rendu;
import com.example.rendu.repository.RenduRepository;
import com.example.rendu.service.RenduService;
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


    @Override
    public RenduDTO save(RenduDTO renduDTO) {
        if (renduDTO.getIdApprent() == null) {
            throw new IllegalArgumentException("L'identifiant de l'apprenant (idApprent) est requis");
        }

        ApprenantDTO apprenant = apprentClientFeign.getById(renduDTO.getIdApprent());

        if (apprenant == null) {
            throw new RuntimeException("Apprenant non trouvé avec l'ID : " + renduDTO.getIdApprent());
        }

        Rendu rendu = mapper.toEntity(renduDTO);
        rendu.setApprenantId(renduDTO.getIdApprent());

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

