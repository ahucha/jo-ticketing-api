package com.example.ticketing.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ticketing.entities.Stadium;
import com.example.ticketing.repositories.StadiumRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StadiumService {
    @Autowired
    private StadiumRepository stadiumRepository;

    public Stadium addStadium(Stadium stadium) {
        return stadiumRepository.save(stadium);
    }

    public List<Stadium> getAllStadiums() {
        return stadiumRepository.findAll();
    }

    public Optional<Stadium> getStadiumById(Long id) {
        return stadiumRepository.findById(id);
    }

    public Stadium updateStadium(Long id, Stadium stadiumDetails) {
        Optional<Stadium> stadiumOptional = stadiumRepository.findById(id);
        if (stadiumOptional.isPresent()) {
            Stadium stadium = stadiumOptional.get();
            stadium.setName(stadiumDetails.getName());
            stadium.setCapacity(stadiumDetails.getCapacity());
            return stadiumRepository.save(stadium);
        } else {
            return null;
        }
    }

    public void deleteStadium(Long id) {
        stadiumRepository.deleteById(id);
    }
}
