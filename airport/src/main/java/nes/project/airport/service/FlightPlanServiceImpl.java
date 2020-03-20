package nes.project.airport.service;

import nes.project.airport.model.FlightPlan;
import nes.project.airport.repositories.FlightPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightPlanServiceImpl implements FlightPlanService {

    private FlightPlanRepository flightPlanRepository;

    @Autowired
    public void FlightPlanService(FlightPlanRepository flightPlanRepository) {
        this.flightPlanRepository = flightPlanRepository;
    }

    @Override
    public Iterable<FlightPlan> listAllFlightPlans() {return flightPlanRepository.findAll();}

    @Override
    public FlightPlan getFlightPlanById(Integer flightPlanId) {return flightPlanRepository.findOne(flightPlanId);}

    @Override
    public FlightPlan saveFlightPlan(FlightPlan flightPlan) {return flightPlanRepository.save(flightPlan);}

    @Override
    public void deleteFlightPlan(Integer flightPlanId) {flightPlanRepository.delete(flightPlanId);}
}
