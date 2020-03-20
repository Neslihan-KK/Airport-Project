package nes.project.airport.service;


import nes.project.airport.model.FlightTicket;

public interface FlightTicketService {

    Iterable<FlightTicket> listAllFlightTickets();

    FlightTicket getFlightTicketById(Integer flightTicketId);

    FlightTicket saveFlightTicket(FlightTicket flightTicket);

    void deleteFlightTicket(Integer flightTicketId);
}
