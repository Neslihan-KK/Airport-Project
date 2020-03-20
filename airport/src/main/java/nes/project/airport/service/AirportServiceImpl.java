package nes.project.airport.service;

import nes.project.airport.model.Airports;
import nes.project.airport.repositories.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirportServiceImpl implements AirportService {

    private AirportRepository airportRepository;

    @Autowired
    public void AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @Override
    public Iterable<Airports> listAllAirports() {return airportRepository.findAll();}

    @Override
    public Airports getAirportById(Integer airportId) {return airportRepository.findOne(airportId);}

    @Override
    public Airports saveAirport(Airports airports) {return airportRepository.save(airports);}

    @Override
    public void deleteAirport(Integer airportId) {airportRepository.delete(airportId); }
}
