package org.example.bref.service;

import lombok.AllArgsConstructor;
import org.example.bref.dto.BrefDto;
import org.example.bref.entity.Bref;
import org.example.bref.repository.BrefRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BrefService {
    private  final BrefRepository brefRepository;
    private final ModelMapper modelMapper;
    public BrefDto create(BrefDto brefDto) {
        Bref bref = modelMapper.map(brefDto, Bref.class);
        Bref brefCreated = brefRepository.save(bref);
        return modelMapper.map(brefCreated, BrefDto.class);
    }

}
