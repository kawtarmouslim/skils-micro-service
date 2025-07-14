package com.example.rendu.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompetenceDto {
    Long id;
    String competence;
    String description;
    boolean etatValidation;

}
