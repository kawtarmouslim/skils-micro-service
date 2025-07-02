package org.example.competence.controller;

import lombok.AllArgsConstructor;
import org.example.competence.dto.SousCompetenceDto;
import org.example.competence.entite.SousCompetence;
import org.example.competence.service.SousCompetenceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/sousCompetence")
public class SousSousCompetence {
    private  final SousCompetenceService sousCompetenceService;
    @PostMapping("add")
    public SousCompetenceDto addSousCompetence(@RequestBody SousCompetenceDto sousCompetenceDto) {
       return sousCompetenceService.save(sousCompetenceDto);
    }
    @GetMapping("/{id}")
    public ResponseEntity<SousCompetenceDto> getSousCompetenceById(@PathVariable Long id) {
        SousCompetenceDto dto = sousCompetenceService.getById(id);
        return ResponseEntity.ok(dto);
    }
    @PatchMapping("/{id}/{etatValidation}")
    public ResponseEntity<SousCompetenceDto> updateEtatValidation(
            @PathVariable Long id,
            @PathVariable boolean etatValidation) {
        SousCompetenceDto updatedDto = sousCompetenceService.updateEtatValidation(id, etatValidation);
        return ResponseEntity.ok(updatedDto);
    }
}
