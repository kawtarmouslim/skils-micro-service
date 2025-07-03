package org.example.competence.service;

import org.example.competence.dto.SousCompetenceDto;
import org.example.competence.entite.Competence;
import org.example.competence.entite.SousCompetence;
import org.example.competence.repository.CompetenceRepository;
import org.example.competence.repository.SousCompletenceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SousCompetenceServiceTest {

    @Mock
    private SousCompletenceRepository sousCompletenceRepository;

    @Mock
    private CompetenceRepository competenceRepository;

    @Mock
    private CompetenceService competenceService;

    private ModelMapper modelMapper = new ModelMapper();

    @InjectMocks
    private SousCompetenceService sousCompetenceService;

    @BeforeEach
    void setUp() {
        // Inject @Mock repositories + vrai ModelMapper dans service manuellement
        sousCompetenceService = new SousCompetenceService(
                sousCompletenceRepository,
                competenceRepository,
                modelMapper,
                competenceService
        );
    }

    @Test
    void testSaveSousCompetence() {
        Competence competence = new Competence();
        competence.setId(1L);
        competence.setSousCompetenceList(new ArrayList<>()); // important pour éviter NullPointerException

        SousCompetenceDto dto = new SousCompetenceDto();
        dto.setName("Java");
        dto.setEtatValidation(false);
        dto.setCompetence_id(1L);

        when(competenceRepository.findById(1L)).thenReturn(Optional.of(competence));
        when(competenceRepository.findByIdWithSousCompetences(1L)).thenReturn(Optional.of(competence));
        when(sousCompletenceRepository.save(any(SousCompetence.class))).thenAnswer(i -> {
            SousCompetence saved = i.getArgument(0);
            saved.setSousCompetenceId(10L); // simulate save
            return saved;
        });

        SousCompetenceDto result = sousCompetenceService.save(dto);

        assertNotNull(result);
        assertEquals("Java", result.getName());
        assertEquals(1L, result.getCompetence_id());
        verify(sousCompletenceRepository).save(any(SousCompetence.class));
    }


    @Test
    void testGetById() {
        Competence competence = new Competence();
        competence.setId(1L);

        SousCompetence sousCompetence = new SousCompetence();
        sousCompetence.setSousCompetenceId(10L);
        sousCompetence.setName("Communication");
        sousCompetence.setEtatValidation(true);
        sousCompetence.setCompetence(competence);

        when(sousCompletenceRepository.findById(10L)).thenReturn(Optional.of(sousCompetence));

        SousCompetenceDto dto = sousCompetenceService.getById(10L);

        assertNotNull(dto);
        assertEquals("Communication", dto.getName());
        assertEquals(1L, dto.getCompetence_id());
    }

    @Test
    void testUpdateEtatValidation() {
        Competence competence = new Competence();
        competence.setId(1L);
        competence.setSousCompetenceList(Arrays.asList(
                createSousCompetence(true), createSousCompetence(true),
                createSousCompetence(true), createSousCompetence(false)
        ));

        SousCompetence sousCompetence = new SousCompetence();
        sousCompetence.setSousCompetenceId(20L);
        sousCompetence.setName("Design Patterns");
        sousCompetence.setEtatValidation(false);
        sousCompetence.setCompetence(competence);

        when(sousCompletenceRepository.findById(20L)).thenReturn(Optional.of(sousCompetence));
        when(competenceRepository.findByIdWithSousCompetences(1L)).thenReturn(Optional.of(competence));
        when(sousCompletenceRepository.save(any(SousCompetence.class))).thenAnswer(i -> i.getArgument(0));

        SousCompetenceDto updated = sousCompetenceService.updateEtatValidation(20L, true);

        assertTrue(updated.isEtatValidation());
        assertEquals("Design Patterns", updated.getName());
        assertEquals(1L, updated.getCompetence_id());

        verify(competenceRepository).save(any(Competence.class));
    }

    private SousCompetence createSousCompetence(boolean etat) {
        SousCompetence s = new SousCompetence();
        s.setEtatValidation(etat);
        return s;
    }
}
