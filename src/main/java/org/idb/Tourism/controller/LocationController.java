package org.idb.Tourism.controller;


import org.idb.Tourism.entity.Hotel;
import org.idb.Tourism.entity.Location;
import org.idb.Tourism.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LocationController {
    @Autowired
    LocationService ls;

    @RequestMapping("/loc-form")
    public String locationForm(Model m){
        m.addAttribute("locationList",ls.getAllLocation());
        m.addAttribute("location", new Location());
        return "location-form";
    }


    @RequestMapping(value = "/location_save", method = RequestMethod.POST)
    public String locationSave(@ModelAttribute("location") Location l, Model m){
        ls.saveLocation(l);
        m.addAttribute("title", "Add Location");
        return "redirect:/loc-form";
    }

    @RequestMapping("/location_list")
    public String allLocation(Model m){
        m.addAttribute("locationList",ls.getAllLocation());
        return "locationlist";
    }


    @RequestMapping("/update_location/{lid}")
    public String updateLocation(@PathVariable("lid") Integer lid, Model m){
        Location l = ls.findLocationById(lid);
        m.addAttribute("location", l);
        return "location-form";
    }

    @RequestMapping("/delete_location/{lid}")
    public String deleteLocation(@PathVariable("lid") Integer lid){
        ls.deleteLocationById(lid);
        return "redirect:/location_list";
    }
}
