package com.example.ticketing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ticketing.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
