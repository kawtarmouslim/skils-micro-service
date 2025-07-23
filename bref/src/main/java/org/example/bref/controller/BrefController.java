package org.example.bref.controller;

import lombok.AllArgsConstructor;
import org.example.bref.BrefApplication;
import org.example.bref.dto.BrefDto;
import org.example.bref.service.BrefService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bref")
@AllArgsConstructor

public class BrefController {

    private final BrefService brefService;
    @PostMapping("addBref")
    public BrefDto createBref(@RequestBody  BrefDto brefDto) {
        return brefService.create(brefDto);
    }
    @GetMapping
    public List<BrefDto> getAllBrefs() {
        return brefService.getAllBrefs();
    }
    @PutMapping("{id}")
    public BrefDto updateBref(@PathVariable Long id, @RequestBody BrefDto brefDto) {
        return brefService.UpdateBref(id, brefDto);
    }
    @DeleteMapping("{id}")
    public void deleteBref(@PathVariable Long id) {
        brefService.deleteBref(id);
    }


    @GetMapping("{id}")
    public BrefDto getBref(@PathVariable Long id) {
        return brefService.getBref(id);
    }
}
