package com.example.spearsexam.repositories;

import com.example.spearsexam.models.Climber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClimberRepository extends JpaRepository<Climber, Long> {
    List<Climber> findAll();
}
