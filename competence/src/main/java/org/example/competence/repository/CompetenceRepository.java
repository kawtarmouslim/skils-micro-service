package org.example.competence.repository;

import org.example.competence.entite.Competence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CompetenceRepository extends JpaRepository<Competence, Long> {

}
