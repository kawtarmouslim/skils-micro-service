package com.example.rendu.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
public class RenduDTO {
    private Long id;

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

    public LocalDateTime getDateRendu() {
        return dateRendu;
    }

    public void setDateRendu(LocalDateTime dateRendu) {
        this.dateRendu = dateRendu;
    }

    private String lienRendu;
    private LocalDateTime dateRendu;
}

