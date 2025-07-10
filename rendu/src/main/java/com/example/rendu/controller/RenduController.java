package com.example.rendu.controller;


import com.example.rendu.dto.RenduDTO;
import com.example.rendu.service.RenduService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rendus")
@RequiredArgsConstructor
public class RenduController {

    private final RenduService service;

    @PostMapping
    public RenduDTO save(@RequestBody RenduDTO dto) {
        return service.save(dto);
    }

    @GetMapping
    public List<RenduDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public RenduDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }


}

