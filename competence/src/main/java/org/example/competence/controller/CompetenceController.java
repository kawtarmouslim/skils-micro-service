package org.example.competence.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.example.competence.dto.CompetenceDto;
import org.example.competence.dto.ProgressReportDto;
import org.example.competence.repository.CompetenceRepository;
import org.example.competence.service.CompetenceService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    @Operation(summary = "Export progress report as CSV", description = "Generates a CSV file containing the progress report for competences and their sub-competences")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "CSV report generated successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping(value = "/progress-report", produces = "text/csv")
    public ResponseEntity<String> exportProgressReport() {
        List<ProgressReportDto> report = competenceService.generateProgressReport();

        StringBuilder csvContent = new StringBuilder();
        csvContent.append("Competence ID,Competence Name,Validated,Percentage Validated,Sous-Competences\n");

        for (ProgressReportDto reportDto : report) {
            csvContent.append(String.format("%d,%s,%b,%.2f%%,",
                    reportDto.getCompetenceId(),
                    reportDto.getCompetenceName(),
                    reportDto.isCompetenceValidated(),
                    reportDto.getPercentageValidated()));

            String sousCompetences = reportDto.getSousCompetences().stream()
                    .map(sc -> String.format("%s (%b)", sc.getName(), sc.isEtatValidation()))
                    .collect(Collectors.joining("; "));
            csvContent.append(sousCompetences).append("\n");
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=progress_report.csv");
        headers.add(HttpHeaders.CACHE_CONTROL, "no-cache, no-store, must-revalidate");
        headers.add(HttpHeaders.PRAGMA, "no-cache");
        headers.add(HttpHeaders.EXPIRES, "0");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.parseMediaType("text/csv"))
                .body(csvContent.toString());
    }
    @GetMapping("{id}")
    public CompetenceDto getCompetenceById(@PathVariable("id") Long id) {
        return competenceService.getCompetenceById(id);

    }
}
