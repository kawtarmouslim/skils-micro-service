package org.example.competence.entite;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Competence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String competence;
    private String description;
    private boolean etatValidation;
    @OneToMany(mappedBy = "competence", cascade = CascadeType.ALL)
    private List<SousCompetence> sousCompetenceList;



}
