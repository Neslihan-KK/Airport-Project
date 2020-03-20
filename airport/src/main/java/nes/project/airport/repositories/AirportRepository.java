package nes.project.airport.repositories;

import nes.project.airport.model.Airports;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airports, Integer> {
}
