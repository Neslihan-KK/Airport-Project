package nes.project.airport.service;


import nes.project.airport.model.FlightPlan;

public interface FlightPlanService {

    Iterable<FlightPlan> listAllFlightPlans();

    FlightPlan getFlightPlanById(Integer flightPlanId);

    FlightPlan saveFlightPlan(FlightPlan flightPlan);

    void deleteFlightPlan(Integer flightPlanId);
}
