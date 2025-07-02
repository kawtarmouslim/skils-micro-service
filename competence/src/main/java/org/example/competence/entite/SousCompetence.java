package org.example.competence.entite;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SousCompetence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sousCompetenceId;
    private  String name;
    private  boolean etatValidation;
    @ManyToOne
    @JoinColumn(name = "competence_id")
    private Competence competence;
}
