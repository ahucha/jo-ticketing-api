package com.example.ticketing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ticketing.entities.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
}
