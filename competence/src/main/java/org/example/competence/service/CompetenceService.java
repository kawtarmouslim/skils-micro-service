package org.example.competence.service;

import lombok.AllArgsConstructor;
import org.example.competence.dto.CompetenceDto;
import org.example.competence.entite.Competence;
import org.example.competence.repository.CompetenceRepository;
import org.example.competence.repository.SousCompletenceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CompetenceService {
    private  final CompetenceRepository competenceRepository;
    private final ModelMapper modelMapper;
    private final SousCompletenceRepository sousCompletenceRepository;
    public CompetenceDto createCompetence(CompetenceDto competenceDto) {
        Competence competence = modelMapper.map(competenceDto, Competence.class);
        Competence result = competenceRepository.save(competence);
        return modelMapper.map(result, CompetenceDto.class);
    }


    public CompetenceDto updateCompetence(Long id,CompetenceDto competenceDto) {
        Competence competence = competenceRepository.findById(id).orElse(null);
        competence.setCompetence(competenceDto.getCompetence());
        competence.setCompetence(competenceDto.getCompetence());
        Competence result = competenceRepository.save(competence);
        return modelMapper.map(result, CompetenceDto.class);
    }


    public void deleteCompetence(Long id) {
        competenceRepository.deleteById(id);
    }
    public List<CompetenceDto> getAllCompetences() {
        List<Competence> competences = competenceRepository.findAll();
        return competences.stream().map(competence -> modelMapper.map(competence, CompetenceDto.class)).collect(Collectors.toList());
    }





}
