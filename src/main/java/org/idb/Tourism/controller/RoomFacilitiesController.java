package org.idb.Tourism.controller;



import org.idb.Tourism.entity.RoomFacilities;
import org.idb.Tourism.service.RoomFacilitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RoomFacilitiesController {
    @Autowired
    RoomFacilitiesService service;

    @RequestMapping("/roomfacilities_form")
    public String roomFacilities_form(Model m){
        m.addAttribute("rfList", new RoomFacilities());
        m.addAttribute("rfaciList",service.getAllRoomFacilities());
        return "roomfacilities-form";
    }

    @RequestMapping("/roomfacilities")
    public String allRoomFacilities(Model m){
        m.addAttribute("rfaciList",service.getAllRoomFacilities());
        m.addAttribute("rfList", new RoomFacilities());
        return "roomfacilitieslist";

    }


    @RequestMapping(value = "/add_roomfacilities", method = RequestMethod.POST)
    public String addNewroomfacilities(@ModelAttribute("rfList") RoomFacilities r, Model m ){
        service.saveRoomFacilities(r);
        return "redirect:/roomfacilities";
    }



    @RequestMapping("/update_roomfacilities/{rfId}")
    public String roomfacilitiesUpdateForm(@PathVariable("rfId") Integer rfId, Model m){
        RoomFacilities r = service.findRoomFacilitiesById(rfId);
        m.addAttribute("rfList", r);
        return "roomfacilities-form";

    }


    @RequestMapping("/delete_roomfacilities/{rfId}")
    public String deleteroomfacilities(@PathVariable("rfId") Integer rfId){
        service.deleteRoomFacilitiesById(rfId);
        return "redirect:/roomfacilities";
    }

}
