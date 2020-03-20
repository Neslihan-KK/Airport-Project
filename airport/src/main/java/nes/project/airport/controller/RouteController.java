package nes.project.airport.controller;

import nes.project.airport.model.Airports;
import nes.project.airport.model.Route;
import nes.project.airport.service.AirportService;
import nes.project.airport.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RouteController {

    private RouteService routeService;

    private AirportService airportService;

    @Autowired
    public void RouteService(RouteService routeService) {this.routeService = routeService;}

    @Autowired
    public void AirportService(AirportService airportService) {
        this.airportService = airportService;
    }

    @RequestMapping(value = "/route/routes", method = RequestMethod.GET)
    public @ResponseBody Iterable<Route> viewRoutes() {
        return routeService.listAllRoutes();
    }

    @RequestMapping(value = "/route/create", method = RequestMethod.POST)
    public @ResponseBody String createRoute (@RequestBody Route route) {
        String result;
        Airports fromAirport = airportService.getAirportById(route.getFromAirportId());
        Airports toAirport = airportService.getAirportById(route.getToAirportId());
        if (fromAirport == null)
            result = route.getFromAirportId() +" Nolu Havalimanı Bulunmamaktadır...";
        else if (toAirport == null)
            result = route.getToAirportId() +" Nolu Havalimanı Bulunmamaktadır...";
        else {
            Route route1 = routeService.saveRoute(route);
            result = route1.getRouteId() +" Nolu Rota Oluşturulmuştur...";
        }
        return result;
    }

    @RequestMapping(value = "/route/route/{id}", method = RequestMethod.GET)
    public @ResponseBody Route viewRoute(@PathVariable Integer id) {
        return routeService.getRouteById(id);
    }

    @RequestMapping(value = "route/delete/{id}", method = RequestMethod.GET)
    public @ResponseBody String deleteRoute(@PathVariable Integer id) {
        String result;
        Route route = routeService.getRouteById(id);
        if (route == null)
            result = id +" Nolu Rota Bulunmamaktadır...";
        else {
            routeService.deleteRoute(id);
            result = id +" Nolu Rota Silinmiştir...";
        }
        return result;
    }
}
