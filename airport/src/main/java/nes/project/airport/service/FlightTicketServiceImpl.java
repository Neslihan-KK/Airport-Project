package nes.project.airport.service;

import nes.project.airport.model.FlightTicket;
import nes.project.airport.repositories.FlightTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightTicketServiceImpl implements FlightTicketService {

    private FlightTicketRepository flightTicketRepository;

    @Autowired
    public void FlightTicketService(FlightTicketRepository flightTicketRepository) {
        this.flightTicketRepository = flightTicketRepository;
    }

    @Override
    public Iterable<FlightTicket> listAllFlightTickets() {return flightTicketRepository.findAll();}

    @Override
    public FlightTicket getFlightTicketById(Integer flightTicketId) {return flightTicketRepository.findOne(flightTicketId);}

    @Override
    public FlightTicket saveFlightTicket(FlightTicket flightTicket) {return flightTicketRepository.save(flightTicket);}

    @Override
    public void deleteFlightTicket(Integer flightTicketId) {flightTicketRepository.delete(flightTicketId);}
}
