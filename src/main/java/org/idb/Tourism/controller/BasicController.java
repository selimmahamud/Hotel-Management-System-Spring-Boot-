package org.idb.Tourism.controller;

import org.idb.Tourism.repository.IHotelRepo;
import org.idb.Tourism.service.HotelFacilitiesService;
import org.idb.Tourism.service.HotelService;
import org.idb.Tourism.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BasicController {


    @Autowired
    HotelService hotelService;

    @Autowired
    LocationService locationService;

    @Autowired
    HotelFacilitiesService hotelFacilitiesService;


//
//    @RequestMapping(value = {"","/","/index","/home"})
//    public String userIndex(Model m){
//        m.addAttribute("locationList", locationService.getAllLocation());
//
//        return "user-index";
//    }

    @RequestMapping("/ad-index")
    public String adminIndex(){

        return "admin-index";
    }

    @RequestMapping(value = {"","/","/index","/home"})
    public String userIndex(Model m){
        m.addAttribute("locationList", locationService.getAllLocation());
        return "user-index";
    }

    @RequestMapping("/u-search")
    public String UserSearch(){

        return "available-hotel-list";
    }


//        List<Hotel> sql="select * from tourism.hotel h join tourism.location l on(h.location_id=l.lid) where l.lcountry='India' and h.hname='Hotel Zahid'" ;

}
