package nes.project.airport.service;


import nes.project.airport.model.Route;

public interface RouteService {

    Iterable<Route> listAllRoutes();

    Route getRouteById(Integer routeId);

    Route saveRoute(Route route);

    void deleteRoute(Integer routeId);
}
