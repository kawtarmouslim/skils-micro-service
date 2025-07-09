package org.example.competence.service;

import lombok.AllArgsConstructor;
import org.example.competence.dto.SousCompetenceDto;
import org.example.competence.entite.Competence;
import org.example.competence.entite.SousCompetence;
import org.example.competence.repository.CompetenceRepository;
import org.example.competence.repository.SousCompletenceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SousCompetenceService {
    private final SousCompletenceRepository sousCompletenceRepository;
    private final CompetenceRepository competenceRepository;
    private final ModelMapper modelMapper;
    private final CompetenceService competenceService;

    public SousCompetenceDto save(SousCompetenceDto sousCompetenceDto) {

        Competence competence = competenceRepository.findById(sousCompetenceDto.getCompetence_id())
                .orElseThrow(() -> new RuntimeException("Event not found"));

        SousCompetence sousCompetence = modelMapper.map(sousCompetenceDto, SousCompetence.class);
        updateCompetenceValidation(competence.getId());
        sousCompetence.setCompetence(competence);
        SousCompetence sousCompetenceSaved = sousCompletenceRepository.save(sousCompetence);
     SousCompetenceDto result = modelMapper.map(sousCompetenceSaved, SousCompetenceDto.class);
          result.setCompetence_id(sousCompetenceDto.getCompetence_id());

           return result;

    }

    public SousCompetenceDto getById(Long id) {
        SousCompetence sousCompetence = sousCompletenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sous-compétence non trouvée"));
        SousCompetenceDto dto = modelMapper.map(sousCompetence, SousCompetenceDto.class);
        if (sousCompetence.getCompetence() != null) {
            dto.setCompetence_id(sousCompetence.getCompetence().getId());
        }
        return dto;
    }


    public SousCompetenceDto updateEtatValidation(Long id, boolean etatValidation) {
        SousCompetence sousCompetence = sousCompletenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sous-compétence non trouvée avec id: " + id));


        sousCompetence.setEtatValidation(etatValidation);
        SousCompetence updated = sousCompletenceRepository.save(sousCompetence);
        updateCompetenceValidation(updated.getCompetence().getId());
        SousCompetenceDto dto = modelMapper.map(updated, SousCompetenceDto.class);
        dto.setCompetence_id(updated.getCompetence().getId());
        return dto;
    }


    private void updateCompetenceValidation(Long competenceId) {
        Competence competence = competenceRepository.findByIdWithSousCompetences(competenceId)
                .orElseThrow(() -> new RuntimeException("Competence not found"));
         //calc nmb tot de sous c lie a un c
        long totalSousCompetences = competence.getSousCompetenceList().size();
        //compte seulemet les sc valider
        long validatedSousCompetences = competence.getSousCompetenceList().stream()
                .filter(SousCompetence::isEtatValidation)
                .count();

        //boolean isCompetenceValidated = totalSousCompetences > 0 && validatedSousCompetences == totalSousCompetences;
        // Alternative : compétence acquise si au moins 75 % des sous-compétences sont validées
        boolean isCompetenceValidated = totalSousCompetences > 0 &&
               ((double) validatedSousCompetences / totalSousCompetences) >= 0.75;

        competence.setEtatValidation(isCompetenceValidated);
        competenceRepository.save(competence);
    }
}