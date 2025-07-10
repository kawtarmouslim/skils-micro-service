package org.example.competence.repository;

import org.example.competence.entite.SousCompetence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SousCompletenceRepository extends JpaRepository<SousCompetence, Long> {


}
