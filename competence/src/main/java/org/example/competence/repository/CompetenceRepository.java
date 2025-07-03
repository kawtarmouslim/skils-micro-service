package org.example.competence.repository;

import org.example.competence.entite.Competence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CompetenceRepository extends JpaRepository<Competence, Long> {
    @Query("SELECT c FROM Competence c LEFT JOIN FETCH c.sousCompetenceList WHERE c.id = :id")
    Optional<Competence> findByIdWithSousCompetences(@Param("id") Long id);
}
