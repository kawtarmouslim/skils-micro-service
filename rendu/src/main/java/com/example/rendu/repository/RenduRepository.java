package com.example.rendu.repository;


import com.example.rendu.model.Rendu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RenduRepository extends JpaRepository<Rendu, Long> {
    @Query(value = "select  count (idBref) from rendu where idApprent=?",nativeQuery = true)
    Integer getCount(Long idapprent);


}
