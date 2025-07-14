package com.example.rendu.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Competence {
    Long id;
    String competence;
    String description;
    boolean etatValidation;

}
