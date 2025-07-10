package org.example.bref.controller;

import lombok.AllArgsConstructor;
import org.example.bref.BrefApplication;
import org.example.bref.dto.BrefDto;
import org.example.bref.service.BrefService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
@AllArgsConstructor

public class BrefController {

    private final BrefService brefService;
    @PostMapping("addBref")
    public BrefDto createBref(BrefDto brefDto) {
        return brefService.create(brefDto);
    }


}
