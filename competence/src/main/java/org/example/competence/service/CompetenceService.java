package org.example.competence.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.example.competence.dto.CompetenceDto;
import org.example.competence.dto.ProgressReportDto;
import org.example.competence.entite.Competence;
import org.example.competence.entite.SousCompetence;
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
    public CompetenceDto getCompetenceById(Long id) {
        Competence competence = competenceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Compétence non trouvée avec l'id : " + id));
        return modelMapper.map(competence, CompetenceDto.class);
    }



    public List<ProgressReportDto> generateProgressReport() {
        List<Competence> competences = competenceRepository.findAll();
        return competences.stream().map(competence -> {
            ProgressReportDto reportDto = new ProgressReportDto();
            reportDto.setCompetenceId(competence.getId());
            reportDto.setCompetenceName(competence.getCompetence());
            reportDto.setCompetenceValidated(competence.isEtatValidation());

            // Calculer le pourcentage de sous-compétences validées
            long totalSousCompetences = competence.getSousCompetenceList().size();
            long validatedSousCompetences = competence.getSousCompetenceList().stream()
                    .filter(SousCompetence::isEtatValidation)
                    .count();
            double percentage = totalSousCompetences > 0 ?
                    (double) validatedSousCompetences / totalSousCompetences * 100 : 0;
            reportDto.setPercentageValidated(percentage);

            // Mapper les sous-compétences
            List<ProgressReportDto.SousCompetenceReportDto> sousCompetenceDtos =
                    competence.getSousCompetenceList().stream()
                            .map(sc -> {
                                ProgressReportDto.SousCompetenceReportDto scDto =
                                        new ProgressReportDto.SousCompetenceReportDto();
                                scDto.setSousCompetenceId(sc.getSousCompetenceId());
                                scDto.setName(sc.getName());
                                scDto.setEtatValidation(sc.isEtatValidation());
                                return scDto;
                            })
                            .collect(Collectors.toList());
            reportDto.setSousCompetences(sousCompetenceDtos);

            return reportDto;
        }).collect(Collectors.toList());
    }


}
