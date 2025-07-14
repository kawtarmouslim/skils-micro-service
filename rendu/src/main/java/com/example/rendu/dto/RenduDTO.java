package com.example.rendu.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
public class RenduDTO {
    private Long id;
    private String lienRendu;
    private LocalDateTime dateRendu;
    private Long idCompetence;

    private Long idApprent;
    private Long idBref;

    public Long getId() {
        return id;
    }

    public Long getIdBref() {
        return idBref;
    }

    public void setIdBref(Long idBref) {
        this.idBref = idBref;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLienRendu() {
        return lienRendu;
    }

    public void setLienRendu(String lienRendu) {
        this.lienRendu = lienRendu;
    }

    public LocalDateTime getDateRendu() {
        return dateRendu;
    }

    public void setDateRendu(LocalDateTime dateRendu) {
        this.dateRendu = dateRendu;
    }

    public Long getIdApprent() {
        return idApprent;
    }

    public void setIdApprent(Long idApprent) {
        this.idApprent = idApprent;
    }

    public Long getIdCompetence() {
        return idCompetence;
    }

    public void setIdCompetence(Long idCompetence) {
        this.idCompetence = idCompetence;
    }
}

