package com.example.rendu.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor

public class Bref {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBref;
    private String titre;
    private String description;
    private Date debut;

    public Long getIdBref() {
        return idBref;
    }

    public void setIdBref(Long idBref) {
        this.idBref = idBref;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    private Date fin;

}
