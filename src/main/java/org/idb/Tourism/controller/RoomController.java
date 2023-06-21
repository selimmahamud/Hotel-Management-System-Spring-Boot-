package org.idb.Tourism.controller;

import org.idb.Tourism.entity.Room;
import org.idb.Tourism.service.HotelService;
import org.idb.Tourism.service.RoomFacilitiesService;
import org.idb.Tourism.service.RoomService;
import org.idb.Tourism.service.RoomtypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class RoomController {
    @Autowired
    RoomService roomService;

    @Autowired
    RoomtypeService roomtypeService;


    @Autowired
    RoomFacilitiesService roomFacilitiesService;

    @Autowired
    HotelService hotelService;



    @RequestMapping("/roomhome")
    public String home(){
        return "roomhome";
    }
//----------------- save for room from--------------------


    @RequestMapping("/room_form")
    public String addRoomForm(Model m){
        m.addAttribute("room" , new Room());
        m.addAttribute("roomlist" , roomService.getAllRoom());
        m.addAttribute("roomtypelist" , roomtypeService.getAllRoomtype());
        m.addAttribute("roomfaclist" , roomFacilitiesService.getAllRoomFacilities());
        m.addAttribute("hotellist" , hotelService.getAllHotel());


        return "room-form";
    }


    @RequestMapping("/room_list")
    public String roomList(Model m){
        m.addAttribute("roomlist" , roomService.getAllRoom());
        m.addAttribute("roomtypelist" , roomtypeService.getAllRoomtype());
        m.addAttribute("roomfaclist" , roomFacilitiesService.getAllRoomFacilities());
        m.addAttribute("hotellist" , hotelService.getAllHotel());

        m.addAttribute("room" , new Room());
        return "roomlist";
    }

    @RequestMapping(value = "/add_room", method = RequestMethod.POST)
    public  String roomSave(@ModelAttribute("room") Room r, Model m){
        roomService.saveRoom(r);
        return "redirect:/room_form";
    }
    @RequestMapping("/delete_room/{rId}")
    public String deleteRoom(@PathVariable("rId") Integer rId){
        roomService.deleteRoomById(rId);
        return "redirect:/room_list";
    }

    @RequestMapping("/update_room/{rId}")
    public String updateRoom(@PathVariable("rId") Integer rId, Model m){
      Room r =  roomService.findRoomById(rId);
        m.addAttribute("room", r);
        m.addAttribute("roomtypelist", roomtypeService.getAllRoomtype());
        m.addAttribute("roomfaclist", roomFacilitiesService.getAllRoomFacilities());
        m.addAttribute("hotellist", hotelService.getAllHotel());
        return "room-form";
    }

//-------------------------------------------------------------------------------------





}
