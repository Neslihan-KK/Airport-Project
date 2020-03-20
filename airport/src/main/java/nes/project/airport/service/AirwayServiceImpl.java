package nes.project.airport.service;

import nes.project.airport.model.Airways;
import nes.project.airport.repositories.AirwayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirwayServiceImpl implements AirwayService {

    private AirwayRepository airwayRepository;

    @Autowired
    public void AirwayService(AirwayRepository airwayRepository) {
        this.airwayRepository = airwayRepository;
    }

    @Override
    public Iterable<Airways> listAllAirways() {return airwayRepository.findAll();}

    @Override
    public Airways getAirwayById(Integer airwayId) {return airwayRepository.findOne(airwayId);}

    @Override
    public Airways saveAirway(Airways airways) {return airwayRepository.save(airways);}

    @Override
    public void deleteAirway(Integer airwayId) {airwayRepository.delete(airwayId);}
}
