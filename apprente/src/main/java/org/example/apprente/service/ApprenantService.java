package org.example.apprente.service;


import lombok.RequiredArgsConstructor;
import org.example.apprente.dto.ApprenantDTO;
import org.example.apprente.mapper.ApprenantMapper;
import org.example.apprente.repository.ApprenantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApprenantService {

    private final ApprenantRepository repository;
    private final ApprenantMapper mapper;

    public ApprenantDTO create(ApprenantDTO dto) {
        return mapper.toDTO(repository.save(mapper.toEntity(dto)));
    }

    public List<ApprenantDTO> findAll() {
        return mapper.toDTOs(repository.findAll());
    }

    public ApprenantDTO findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Apprenant not found"));
    }

    public ApprenantDTO update(Long id, ApprenantDTO dto) {
        ApprenantDTO existing = findById(id);
        dto.setId(existing.getId());

        return mapper.toDTO(repository.save(mapper.toEntity(dto)));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}


