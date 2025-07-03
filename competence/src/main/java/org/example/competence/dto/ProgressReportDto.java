package org.example.competence.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class ProgressReportDto implements Serializable {
    private Long competenceId;
    private String competenceName;
    private boolean competenceValidated;
    private double percentageValidated;
    private List<SousCompetenceReportDto> sousCompetences;

    @Getter
    @Setter
    public static class SousCompetenceReportDto implements Serializable {
        private Long sousCompetenceId;
        private String name;
        private boolean etatValidation;
    }
}