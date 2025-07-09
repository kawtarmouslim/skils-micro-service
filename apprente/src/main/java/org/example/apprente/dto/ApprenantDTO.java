package org.example.apprente.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApprenantDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
}

