package nes.project.airport.controller;

import nes.project.airport.model.Airports;
import nes.project.airport.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AirportController {

    private AirportService airportService;

    @Autowired
    public void AirportService(AirportService airportService) {
        this.airportService = airportService;
    }

    @RequestMapping(value = "/airport/airports", method = RequestMethod.GET)
    public @ResponseBody Iterable<Airports> viewAirports() {
        return airportService.listAllAirports();
    }

    @RequestMapping(value = "/airport/create", method = RequestMethod.POST)
    public @ResponseBody String createAirport(@RequestBody Airports airports) {
        Airports airports1 = airportService.saveAirport(airports);
        return airports1.getAirportId() +" Nolu Havalimanı Oluşturulmuştur...";
    }

    @RequestMapping(value = "/airport/airport/{id}", method = RequestMethod.GET)
    public @ResponseBody Airports viewAirport(@PathVariable Integer id) {
        return airportService.getAirportById(id);
    }

    @RequestMapping(value = "airport/delete/{id}", method = RequestMethod.GET)
    public @ResponseBody  String deleteAirport(@PathVariable Integer id) {
        String result;
        Airports airport = airportService.getAirportById(id);
        if (airport == null)
            result = id +" Nolu Havalimanı Bulunmamaktadır...";
        else {
            airportService.deleteAirport(id);
            result = id +" Nolu Havalimanı Silinmiştir...";
        }
        return result;
    }
}
