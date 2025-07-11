package com.example.rendu.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Rendu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lienRendu;
    private Long apprenantId;
    private LocalDateTime dateRendu;
    private  Long idBref;

    public Long getIdBref() {
        return idBref;
    }

    public void setIdBref(Long idBref) {
        this.idBref = idBref;
    }

    public Long getId() {
        return id;
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
}

