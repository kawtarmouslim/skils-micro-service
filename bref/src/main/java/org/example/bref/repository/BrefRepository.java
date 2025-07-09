package org.example.bref.repository;

import org.example.bref.entity.Bref;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrefRepository extends JpaRepository<Bref, Long> {
}
