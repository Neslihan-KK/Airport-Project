package nes.project.airport.repositories;

import nes.project.airport.model.FlightTicket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightTicketRepository extends JpaRepository<FlightTicket, Integer> {
}
