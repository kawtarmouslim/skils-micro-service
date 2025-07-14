package com.example.rendu.clientFeign;

import com.example.rendu.dto.CompetenceDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@FeignClient(name = "competence", url = "http://localhost:8090")

public interface CompetenceFeign {

    @PostMapping("api/v1/add")
    public CompetenceDto addCompetence(@RequestBody CompetenceDto competenceDto) ;

    @PutMapping("api/v1/{id}")
    public CompetenceDto updateCompetence(@PathVariable Long id, @RequestBody CompetenceDto competenceDto);

    @DeleteMapping("api/v1/{id}")
    public void deleteCompetence(@PathVariable Long id) ;

    @GetMapping("api/v1/")
    public List<CompetenceDto> getCompetences() ;

    @GetMapping("api/v1/{id}")
    public CompetenceDto getCompetenceById(@PathVariable("id") Long id);

}

