package nes.project.airport.service;

import nes.project.airport.model.Airports;

public interface AirportService {

    Iterable<Airports> listAllAirports();

    Airports getAirportById(Integer airportId);

    Airports saveAirport(Airports airports);

    void deleteAirport(Integer airportId);
}
