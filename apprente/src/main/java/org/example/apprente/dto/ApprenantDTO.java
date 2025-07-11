package org.example.apprente.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApprenantDTO {
    private Long idApprent;
    private String nom;
    private String prenom;
    private String email;
}

