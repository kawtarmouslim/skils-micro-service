package org.example.competence.dto;

import lombok.*;
import org.example.competence.entite.Competence;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompetenceDto implements Serializable {
    Long id;
    String competence;
    String description;
    boolean etatValidation;

}