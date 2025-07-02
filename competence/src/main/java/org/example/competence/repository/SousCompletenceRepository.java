package org.example.competence.repository;

import org.example.competence.entite.SousCompetence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SousCompletenceRepository extends JpaRepository<SousCompetence, Long> {
    long countByCompetenceIdAndEtatValidationTrue(Long competenceId);
    long countByCompetenceId(Long competenceId);
}
