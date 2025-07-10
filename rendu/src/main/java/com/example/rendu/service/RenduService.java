package com.example.rendu.service;


import com.example.rendu.dto.RenduDTO;

import java.util.List;

public interface RenduService {
    RenduDTO save(RenduDTO renduDTO);
    List<RenduDTO> getAll();
    RenduDTO getById(Long id);
}

