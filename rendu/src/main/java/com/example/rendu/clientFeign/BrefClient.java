package com.example.rendu.clientFeign;

import com.example.rendu.dto.BrefDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "bref", url = "http://localhost:8087")

public interface BrefClient {
    @PostMapping("api/v1/addBref")
    public BrefDto createBref(@RequestBody BrefDto brefDto);
    @GetMapping
    public List<BrefDto> getAllBrefs();
    @PutMapping("{id}")
    public BrefDto updateBref(@PathVariable Long id, @RequestBody BrefDto brefDto) ;
    @DeleteMapping("{id}")
    public void deleteBref(@PathVariable Long id) ;

    @GetMapping("api/v1/{id}")
    BrefDto getBref(@PathVariable Long id);}
