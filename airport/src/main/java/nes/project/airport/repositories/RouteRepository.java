package nes.project.airport.repositories;

import nes.project.airport.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route, Integer> {
}
