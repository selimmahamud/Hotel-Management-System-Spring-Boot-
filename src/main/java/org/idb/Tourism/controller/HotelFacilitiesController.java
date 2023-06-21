package org.idb.Tourism.controller;

import org.idb.Tourism.entity.Hotel;
import org.idb.Tourism.entity.HotelFacilities;
import org.idb.Tourism.service.HotelFacilitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HotelFacilitiesController {

    @Autowired
    HotelFacilitiesService hotelFacilitiesService;

    @RequestMapping("/hf-form")
    public String hFaciForm(Model m){
        m.addAttribute("hfList", hotelFacilitiesService.getALlHFacilities());
        m.addAttribute("hfacilities", new HotelFacilities());
//        m.addAttribute("messege", "Hotel facilities successfully added!!");
        return "hotel-facilities-form";
    }

    @RequestMapping(value = "/add_h_facilities", method = RequestMethod.POST)
    public String hFaciAdd(@ModelAttribute("hfacilities") HotelFacilities hf, Model m) {
        hotelFacilitiesService.saveHFacilities(hf);
        return "redirect:/hf-form";
    }

    @RequestMapping("/h_fac_list")
    public String hFaciLsit(Model m) {
        m.addAttribute("hfList",hotelFacilitiesService.getALlHFacilities());
        return "hotelfacilitieslist";
    }

    @RequestMapping("/edit_hfacilities/{hfacid}")
    public String hFaciUpdate(@ModelAttribute("hfacid") Integer hfacid, Model m){
        HotelFacilities r= hotelFacilitiesService.findHFacById(hfacid);
        m.addAttribute("hfacilities", r);
        return "hotel-facilities-form";
    }


    @RequestMapping("/delete_hfacilities/{hfacid}")
    public  String hFaciDelete(@ModelAttribute("hfacid") Integer hfacid, Model m){
        hotelFacilitiesService.deleteHFacById(hfacid);
        return "redirect:/h_fac_list";
    }

}
