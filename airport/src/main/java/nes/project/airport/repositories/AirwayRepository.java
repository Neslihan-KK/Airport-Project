package nes.project.airport.repositories;

import nes.project.airport.model.Airways;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirwayRepository extends JpaRepository<Airways, Integer> {
}
