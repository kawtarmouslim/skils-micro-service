package org.example.bref.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompetenceDto {
    Long id;
    String competence;
    String description;
    boolean etatValidation;
}
