package org.example.competence.controller;

import lombok.AllArgsConstructor;
import org.example.competence.dto.CompetenceDto;
import org.example.competence.repository.CompetenceRepository;
import org.example.competence.service.CompetenceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
@AllArgsConstructor
public class CompetenceController {
    private  final CompetenceService competenceService;
    @PostMapping("add")
    public CompetenceDto addCompetence(@RequestBody CompetenceDto competenceDto) {
        CompetenceDto competenceDto1=competenceService.createCompetence(competenceDto);
        return competenceDto1;
    }
    @PutMapping("{id}")
    public CompetenceDto updateCompetence(@PathVariable Long id, @RequestBody CompetenceDto competenceDto) {
        return competenceService.updateCompetence(id, competenceDto);
    }
    @DeleteMapping("{id}")
    public void deleteCompetence(@PathVariable Long id) {
        competenceService.deleteCompetence(id);
    }
    @GetMapping
    public List<CompetenceDto> getCompetences() {
        return competenceService.getAllCompetences();
    }

}
