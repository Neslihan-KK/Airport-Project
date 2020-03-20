package nes.project.airport.controller;

import nes.project.airport.model.FlightPlan;
import nes.project.airport.model.FlightTicket;
import nes.project.airport.service.FlightPlanService;
import nes.project.airport.service.FlightTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class FlightTicketController {

    private FlightTicketService flightTicketService;

    private FlightPlanService flightPlanService;

    @Autowired
    public void FlightTicketService(FlightTicketService flightTicketService) {
        this.flightTicketService = flightTicketService;
    }

    @Autowired
    public void FlightPlanService(FlightPlanService flightPlanService) {
        this.flightPlanService = flightPlanService;
    }

    @RequestMapping(value = "/flightticket/flighttickets", method = RequestMethod.GET)
    public @ResponseBody Iterable<FlightTicket> viewFlightTickets() {
        return flightTicketService.listAllFlightTickets();
    }

    @RequestMapping(value = "/flightticket/create", method = RequestMethod.POST)
    public @ResponseBody String createFlightTicket(@RequestBody FlightTicket flightTicket) {
        String result;
        FlightPlan flightPlan = flightPlanService.getFlightPlanById(flightTicket.getFlightPlanId());
        if (flightPlan == null)
            result = flightTicket.getFlightPlanId() +" Nolu Uçuş Planı Bulunmamaktadır...";
        else {
            Float percent = flightPlan.getFullSeatCount().floatValue() / flightPlan.getPlaneCapacity().floatValue() * 10;
            Float percent1 = (flightPlan.getFullSeatCount().floatValue() + 1) / flightPlan.getPlaneCapacity().floatValue() * 10;
            Double ticketPrice = flightPlan.getTicketPrice();
            if (percent.intValue() != percent1.intValue())
                ticketPrice = flightPlan.getTicketPrice() + flightPlan.getTicketPrice() * 0.1;
            flightPlan.setTicketPrice(ticketPrice);
            flightPlan.setFullSeatCount(flightPlan.getFullSeatCount() + 1);
            flightPlanService.saveFlightPlan(flightPlan);
            flightTicket.setTicketPrice(ticketPrice);
            FlightTicket flightTicket1 = flightTicketService.saveFlightTicket(flightTicket);
            result = flightTicket1.getFlightTicketId() +" Nolu Bilet Oluşturulmuştur...";
        }
        return result;
    }

    @RequestMapping(value = "/flightticket/flightticket/{id}", method = RequestMethod.GET)
    public @ResponseBody FlightTicket viewFlightTicket(@PathVariable Integer id) {
        return flightTicketService.getFlightTicketById(id);
    }

    @RequestMapping(value = "/flightticket/delete/{id}", method = RequestMethod.GET)
    public @ResponseBody  String deleteFlightTicket(@PathVariable Integer id) {
        String result;
        FlightTicket flightTicket = viewFlightTicket(id);
        if (flightTicket == null)
            result = id +" Nolu Bilet Bulunmamaktadır...";
        else {
            FlightPlan flightPlan = flightPlanService.getFlightPlanById(flightTicket.getFlightPlanId());
            Float percent = flightPlan.getFullSeatCount().floatValue() / flightPlan.getPlaneCapacity().floatValue() * 10;
            Float percent1 = (flightPlan.getFullSeatCount().floatValue() - 1) / flightPlan.getPlaneCapacity().floatValue() * 10;
            Double ticketPrice = flightPlan.getTicketPrice();
            if (percent.intValue() != percent1.intValue())
                ticketPrice = flightPlan.getTicketPrice() - flightPlan.getTicketPrice() * 0.1;
            flightPlan.setTicketPrice(ticketPrice);
            flightPlan.setFullSeatCount(flightPlan.getFullSeatCount() - 1);
            flightPlanService.saveFlightPlan(flightPlan);
            flightTicket.setTicketPrice(ticketPrice);
            flightTicketService.deleteFlightTicket(id);
            result = id +" Nolu Bilet Silinmiştir...";
        }
        return result;
    }
}
