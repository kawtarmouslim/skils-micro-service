package com.example.rendu.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class RenduDTO {
    private Long idRendu;
    private String lienRendu;
    private LocalDateTime dateRendu;
    private Long idApprent;
    private Long idBref;
    private List<Long> id;


    public Long getIdRendu() {
        return idRendu;
    }

    public void setIdRendu(Long idRendu) {
        this.idRendu = idRendu;
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

    public Long getIdBref() {
        return idBref;
    }

    public List<Long> getId() {
        return id;
    }

    public void setId(List<Long> id) {
        this.id = id;
    }

    public void setIdBref(Long idBref) {
        this.idBref = idBref;
    }


}

