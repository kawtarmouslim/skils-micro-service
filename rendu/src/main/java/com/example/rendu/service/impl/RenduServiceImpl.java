package com.example.rendu.service.impl;


import com.example.rendu.dto.RenduDTO;
import com.example.rendu.mapper.RenduMapper;
import com.example.rendu.model.Rendu;
import com.example.rendu.repository.RenduRepository;
import com.example.rendu.service.RenduService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RenduServiceImpl implements RenduService {

    private final RenduRepository repository;
    private final RenduMapper mapper;

    @Override
    public RenduDTO save(RenduDTO renduDTO) {
        Rendu rendu = mapper.toEntity(renduDTO);
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

