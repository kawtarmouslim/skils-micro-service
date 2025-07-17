package com.example.rendu.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Rendu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRendu;
    private String lienRendu;
    private Long apprenantId;
    private LocalDateTime dateRendu;
    private  Long idBref;

    @ElementCollection

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

    public Long getApprenantId() {
        return apprenantId;
    }

    public void setApprenantId(Long apprenantId) {
        this.apprenantId = apprenantId;
    }

    public LocalDateTime getDateRendu() {
        return dateRendu;
    }

    public void setDateRendu(LocalDateTime dateRendu) {
        this.dateRendu = dateRendu;
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

