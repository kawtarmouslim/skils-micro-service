package org.example.competence.service;
import org.example.competence.dto.CompetenceDto;
import org.example.competence.entite.Competence;
import org.example.competence.repository.CompetenceRepository;
import org.example.competence.repository.SousCompletenceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class CompetenceServiceTest {

    private CompetenceRepository competenceRepository;
    private SousCompletenceRepository sousCompletenceRepository;
    private ModelMapper modelMapper;
    private CompetenceService competenceService;

    @BeforeEach
    void setUp() {
        competenceRepository = mock(CompetenceRepository.class);
        sousCompletenceRepository = mock(SousCompletenceRepository.class);
        modelMapper = new ModelMapper();
        competenceService = new CompetenceService(competenceRepository, modelMapper, sousCompletenceRepository);
    }

    @Test
    void testCreateCompetence() {
        CompetenceDto dto = new CompetenceDto();
        dto.setCompetence("Communication");

        Competence competence = modelMapper.map(dto, Competence.class);
        competence.setId(1L);

        when(competenceRepository.save(any(Competence.class))).thenReturn(competence);

        CompetenceDto savedDto = competenceService.createCompetence(dto);

        assertNotNull(savedDto);
        assertEquals("Communication", savedDto.getCompetence());
    }

    @Test
    void testUpdateCompetence() {
        Competence existing = new Competence();
        existing.setId(1L);
        existing.setCompetence("Ancienne");

        when(competenceRepository.findById(1L)).thenReturn(Optional.of(existing));
        when(competenceRepository.save(any(Competence.class))).thenAnswer(i -> i.getArgument(0));

        CompetenceDto updateDto = new CompetenceDto();
        updateDto.setCompetence("Nouvelle");

        CompetenceDto updated = competenceService.updateCompetence(1L, updateDto);

        assertEquals("Nouvelle", updated.getCompetence());
        verify(competenceRepository).save(any(Competence.class));
    }

    @Test
    void testDeleteCompetence() {
        Long id = 1L;
        competenceService.deleteCompetence(id);
        verify(competenceRepository).deleteById(id);
    }

    @Test
    void testGetAllCompetences() {
        Competence c1 = new Competence();
        c1.setId(1L);
        c1.setCompetence("C1");

        Competence c2 = new Competence();
        c2.setId(2L);
        c2.setCompetence("C2");

        when(competenceRepository.findAll()).thenReturn(Arrays.asList(c1, c2));

        List<CompetenceDto> list = competenceService.getAllCompetences();

        assertEquals(2, list.size());
        assertEquals("C1", list.get(0).getCompetence());
        assertEquals("C2", list.get(1).getCompetence());
    }
}
