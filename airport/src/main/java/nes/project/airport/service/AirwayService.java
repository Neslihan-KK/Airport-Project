package nes.project.airport.service;


import nes.project.airport.model.Airways;

public interface AirwayService {

    Iterable<Airways> listAllAirways();

    Airways getAirwayById(Integer airwayId);

    Airways saveAirway(Airways airways);

    void deleteAirway(Integer airwayId);
}
