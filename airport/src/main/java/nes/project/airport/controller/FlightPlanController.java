package nes.project.airport.controller;

import nes.project.airport.model.Airways;
import nes.project.airport.model.FlightPlan;
import nes.project.airport.model.Route;
import nes.project.airport.service.AirwayService;
import nes.project.airport.service.FlightPlanService;
import nes.project.airport.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class FlightPlanController {

    private FlightPlanService flightPlanService;

    private AirwayService airwayService;

    private RouteService routeService;

    @Autowired
    public void FlightPlanService(FlightPlanService flightPlanService) {
        this.flightPlanService = flightPlanService;
    }

    @Autowired
    public void AirwayService(AirwayService airwayService) {
        this.airwayService = airwayService;
    }

    @Autowired
    public void RouteService(RouteService routeService) {
        this.routeService = routeService;
    }

    @RequestMapping(value = "/flightplan/flightplans", method = RequestMethod.GET)
    public @ResponseBody Iterable<FlightPlan> viewFlightPlans() {
        return flightPlanService.listAllFlightPlans();
    }

    @RequestMapping(value = "/flightplan/create", method = RequestMethod.POST)
    public @ResponseBody String createFlightPlan(@RequestBody FlightPlan flightPlan) {
        String result;
        Airways airway = airwayService.getAirwayById(flightPlan.getAirwayId());
        Route route = routeService.getRouteById(flightPlan.getRouteId());
        if (airway == null)
            result = flightPlan.getAirwayId() +" Nolu Havayolu Şirketi Bulunmamaktadır...";
        else if (route == null)
            result = flightPlan.getRouteId() +" Nolu Rota Bulunmamaktadır...";
        else {
            flightPlan.setFullSeatCount(0);
            FlightPlan flightPlan1 = flightPlanService.saveFlightPlan(flightPlan);
            result = flightPlan1.getFlightPlanId() +" Nolu Uçuş Planı Oluşturulmuştur...";
        }
        return result;
    }

    @RequestMapping(value = "/flightplan/flightplan/{id}", method = RequestMethod.GET)
    public @ResponseBody FlightPlan viewFlightPlan(@PathVariable Integer id) {
        return flightPlanService.getFlightPlanById(id);
    }

    @RequestMapping(value = "flightplan/delete/{id}", method = RequestMethod.GET)
    public @ResponseBody  String deleteFlightPlan(@PathVariable Integer id) {
        String result;
        FlightPlan flightPlan = flightPlanService.getFlightPlanById(id);
        if (flightPlan == null)
            result = id +" Nolu Uçuş Planı Bulunmamaktadır...";
        else {
            flightPlanService.deleteFlightPlan(id);
            result = id +" Nolu Uçuş Planı Silinmiştir...";
        }
        return result;
    }
}
