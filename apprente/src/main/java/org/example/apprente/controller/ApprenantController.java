package org.example.apprente.controller;

import lombok.RequiredArgsConstructor;
import org.example.apprente.dto.ApprenantDTO;
import org.example.apprente.service.ApprenantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/apprenants")
@RequiredArgsConstructor
public class ApprenantController {

    private final ApprenantService service;

    @PostMapping
    public ApprenantDTO create(@RequestBody ApprenantDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<ApprenantDTO> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ApprenantDTO getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public ApprenantDTO update(@PathVariable Long id, @RequestBody ApprenantDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
