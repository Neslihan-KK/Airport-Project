package nes.project.airport.controller;

import nes.project.airport.model.Airways;
import nes.project.airport.service.AirwayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AirwayController {

    private AirwayService airwayService;

    @Autowired
    public void AirwayService(AirwayService airwayService) {
        this.airwayService = airwayService;
    }

    @RequestMapping(value = "/airway/airways", method = RequestMethod.GET)
    public @ResponseBody Iterable<Airways> viewAirways() {
        return airwayService.listAllAirways();
    }

    @RequestMapping(value = "/airway/create", method = RequestMethod.POST)
    public @ResponseBody String createAirway(@RequestBody Airways airway) {
        Airways airway1 = airwayService.saveAirway(airway);
        return airway1.getAirwayId() +" Nolu Havayolu Oluşturulmuştur...";
    }

    @RequestMapping(value = "/airway/airway/{id}", method = RequestMethod.GET)
    public @ResponseBody Airways viewAirway(@PathVariable Integer id) {
        return airwayService.getAirwayById(id);
    }

    @RequestMapping(value = "airway/delete/{id}", method = RequestMethod.GET)
    public @ResponseBody  String deleteAirway(@PathVariable Integer id) {
        String result;
        Airways airway = airwayService.getAirwayById(id);
        if (airway == null)
            result = id +" Nolu Havayolu Bulunmamaktadır...";
        else {
            airwayService.deleteAirway(id);
            result = id +" Nolu Havayolu Silinmiştir...";
        }
        return result;
    }
}
