package nes.project.airport.repositories;

import nes.project.airport.model.FlightPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightPlanRepository extends JpaRepository<FlightPlan, Integer> {
}
