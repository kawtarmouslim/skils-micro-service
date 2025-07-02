package org.example.competence.dto;

import lombok.*;
import org.example.competence.entite.SousCompetence;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SousCompetenceDto implements Serializable {
    Long sousCompetenceId;
    String name;
    boolean etatValidation;


    public Long getSousCompetenceId() {
        return sousCompetenceId;
    }

    public void setSousCompetenceId(Long sousCompetenceId) {
        this.sousCompetenceId = sousCompetenceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEtatValidation() {
        return etatValidation;
    }

    public void setEtatValidation(boolean etatValidation) {
        this.etatValidation = etatValidation;
    }

    public Long getCompetence_id() {
        return competence_id;
    }

    public void setCompetence_id(Long competence_id) {
        this.competence_id = competence_id;
    }

    Long competence_id;
}