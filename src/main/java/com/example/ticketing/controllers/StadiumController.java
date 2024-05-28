package com.example.ticketing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.ticketing.entities.Stadium;
import com.example.ticketing.services.StadiumService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/stadiums")
public class StadiumController {
    @Autowired
    private StadiumService stadiumService;

    @PostMapping("/add")
    public ResponseEntity<Stadium> addStadium(@RequestBody Stadium stadium) {
        return ResponseEntity.ok(stadiumService.addStadium(stadium));
    }

    @GetMapping
    public ResponseEntity<List<Stadium>> getAllStadiums() {
        return ResponseEntity.ok(stadiumService.getAllStadiums());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stadium> getStadiumById(@PathVariable Long id) {
        Optional<Stadium> stadium = stadiumService.getStadiumById(id);
        return stadium.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Stadium> updateStadium(@PathVariable Long id, @RequestBody Stadium stadiumDetails) {
        Stadium updatedStadium = stadiumService.updateStadium(id, stadiumDetails);
        if (updatedStadium != null) {
            return ResponseEntity.ok(updatedStadium);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStadium(@PathVariable Long id) {
        stadiumService.deleteStadium(id);
        return ResponseEntity.noContent().build();
    }
}
