package org.example.bref.feignClient;

import org.example.bref.dto.CompetenceDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "competence", url = "http://localhost:8090")

public interface CompetenceClientFeign {
    @PostMapping("api/v1/add")
    public CompetenceDto addCompetence(@RequestBody CompetenceDto competenceDto);

    @PutMapping("api/v1/{id}")
    public CompetenceDto updateCompetence(@PathVariable Long id, @RequestBody CompetenceDto competenceDto);


    @GetMapping
    public List<CompetenceDto> getCompetences();

    @GetMapping("api/v1/{id}")
    public CompetenceDto getCompetenceById(@PathVariable("id") Long id) ;

}
