package org.example.competence.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import org.example.competence.entite.Competence;

import java.io.Serializable;

@Getter
@Setter

public class CompetenceDto implements Serializable {
    Long id;
    String competence;
    String description;
}