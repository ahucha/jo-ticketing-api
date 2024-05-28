package com.example.ticketing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ticketing.entities.Stadium;

public interface StadiumRepository extends JpaRepository<Stadium, Long> {
}
