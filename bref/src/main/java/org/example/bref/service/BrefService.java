package org.example.bref.service;

import lombok.AllArgsConstructor;
import org.example.bref.dto.BrefDto;
import org.example.bref.entity.Bref;
import org.example.bref.repository.BrefRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<BrefDto> getAllBrefs() {
        List<Bref> brefs = brefRepository.findAll();
        return brefs.stream().map(bref -> modelMapper.map(bref, BrefDto.class)).collect(Collectors.toList());
    }

    public BrefDto UpdateBref( Long id,BrefDto brefDto) {
        Bref bref = brefRepository.findById(id).orElse(null);

        bref.setDebut(brefDto.getDebut());
        bref.setTitre(brefDto.getTitre());
        bref.setDescription(brefDto.getDescription());
        bref.setFin(brefDto.getFin());

        Bref brefUpdated = brefRepository.save(bref);

        return modelMapper.map(brefUpdated, BrefDto.class);
    }

     public  BrefDto getBref(Long id) {
        Bref bref = brefRepository.findById(id).orElse(null);
        return modelMapper.map(bref, BrefDto.class);

     }
    public void deleteBref(Long id) {
        brefRepository.deleteById(id);
    }

}
