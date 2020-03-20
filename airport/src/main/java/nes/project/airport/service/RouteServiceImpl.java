package nes.project.airport.service;

import nes.project.airport.model.Route;
import nes.project.airport.repositories.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteServiceImpl implements RouteService {

    private RouteRepository routeRepository;

    @Autowired
    public void FlightPlanService(RouteRepository routeRepository) {this.routeRepository = routeRepository;}

    @Override
    public Iterable<Route> listAllRoutes() {return routeRepository.findAll();}

    @Override
    public Route getRouteById(Integer routeId) {return routeRepository.findOne(routeId);}

    @Override
    public Route saveRoute(Route route) {return routeRepository.save(route);}

    @Override
    public void deleteRoute(Integer routeId) {routeRepository.delete(routeId);}
}
