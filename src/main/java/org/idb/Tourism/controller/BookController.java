package org.idb.Tourism.controller;


import org.idb.Tourism.entity.Booking;

import org.idb.Tourism.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {



    @Autowired
    LocationService locationService;
    @Autowired
    HotelService hotelService;
    @Autowired
    HotelFacilitiesService hotelFacilitiesService;
    @Autowired
    RoomService roomService;
    @Autowired
    RoomFacilitiesService roomFacilitiesService;

    @Autowired
    RoomtypeService roomtypeService;

    @Autowired
    BookingService bookingService;

    @RequestMapping("/booking_list")
    public  String hotelList(Model m){
        m.addAttribute("locationList", locationService.getAllLocation());
        m.addAttribute("hotelList", hotelService.getAllHotel());
        m.addAttribute("hotelfacList", hotelFacilitiesService.getALlHFacilities());
        m.addAttribute("roomList", roomService.getAllRoom());
        m.addAttribute("roomFacList", roomFacilitiesService.getAllRoomFacilities());
        m.addAttribute("roomTypeList", roomtypeService.getAllRoomtype());

        m.addAttribute("booking", new Booking());
        return "bookinglist";
    }

    @RequestMapping(value = "/add_booking", method = RequestMethod.POST)
    public  String bookSave(@ModelAttribute("booking") Booking b, Model m){
        bookingService.saveBook(b);
        m.addAttribute("title", "Booking");

        return "redirect:/booking_list";
    }
    @RequestMapping("/delete_booking/{bId}")
    public String deleteHotel(@PathVariable("bId") Integer bId){
        bookingService.deleteBooking(bId);
        return "redirect:/booking_list";
    }

    @RequestMapping("/update_booking/{bId}")
    public String updateHotel(@PathVariable("bId") Integer bId, Model m){
        Booking b = bookingService.findBookingById(bId);
        m.addAttribute("booking", b);
        m.addAttribute("locationList", locationService.getAllLocation());
        m.addAttribute("hotelList", hotelService.getAllHotel());
        m.addAttribute("hotelfacList", hotelFacilitiesService.getALlHFacilities());
        m.addAttribute("roomList", roomService.getAllRoom());
        m.addAttribute("roomFacList", roomFacilitiesService.getAllRoomFacilities());
        m.addAttribute("roomTypeList", roomtypeService.getAllRoomtype());

        return "bookinglist";
    }





}
