package com.example.ticketing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.ticketing.entities.Stadium;
import com.example.ticketing.services.StadiumService;

@RestController
@RequestMapping("/api/stadiums")
public class StadiumController {
    @Autowired
    private StadiumService stadiumService;

    @PostMapping("/add")
    public ResponseEntity<Stadium> addStadium(@RequestBody Stadium stadium) {
        return ResponseEntity.ok(stadiumService.addStadium(stadium));
    }

}
