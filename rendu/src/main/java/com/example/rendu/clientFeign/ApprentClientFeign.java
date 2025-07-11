package com.example.rendu.clientFeign;

import com.example.rendu.dto.ApprenantDTO;
import com.example.rendu.dto.RenduDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "apprente", url = "http://localhost:8081")
public interface ApprentClientFeign {

    @PostMapping("/api/apprenants")
    public ApprenantDTO create(@RequestBody ApprenantDTO dto) ;
    @GetMapping
    public List<ApprenantDTO> getAll();

    @GetMapping("/api/apprenants/{id}")
    public ApprenantDTO getById(@PathVariable Long id) ;

    @PutMapping("/api/apprenants/{id}")
    public ApprenantDTO update(@PathVariable Long id, @RequestBody ApprenantDTO dto) ;



}
