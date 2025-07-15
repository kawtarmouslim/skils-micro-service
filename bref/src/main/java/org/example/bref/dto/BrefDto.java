package org.example.bref.dto;

import lombok.*;
import org.example.bref.entity.Bref;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor

public class BrefDto implements Serializable {
    Long idBref;
    String titre;
    String description;
    Date debut;
    Date fin;
    private List<Long> id;

    public List<Long> getId() {
        return id;
    }

    public void setId(List<Long> id) {
        this.id = id;
    }

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
}