package org.idb.Tourism.controller;

import org.idb.Tourism.entity.Hotel;
import org.idb.Tourism.entity.Location;
import org.idb.Tourism.repository.IHotelRepo;
import org.idb.Tourism.service.HotelFacilitiesService;
import org.idb.Tourism.service.HotelService;
import org.idb.Tourism.service.LocationService;
//import org.idb.Tourism.service.StorageService;
import org.idb.Tourism.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class HotelController {

    @Autowired
    private IHotelRepo iHotelRepo;

    @Autowired
    HotelService hotelService;

    @Autowired
    LocationService locationService;

    @Autowired
    HotelFacilitiesService hotelFacilitiesService;

    @Autowired
    StorageService storageService;


    @RequestMapping("/h-form")
    public String hotelForm(Model m){
        m.addAttribute("hotel", new Hotel());
        m.addAttribute("hotelList", hotelService.getAllHotel());
        m.addAttribute("locationList", locationService.getAllLocation());
        m.addAttribute("hFaciList", hotelFacilitiesService.getALlHFacilities());
        return "hotel-form";
    }

    @RequestMapping(value = "/hotel_save", method = RequestMethod.POST)
    public  String hotelSave(@ModelAttribute("hotel") Hotel h, @RequestParam("pimg") MultipartFile file, Model m)throws IOException {
        String imageName = storageService.uploadImage(file);
        h.setHphoto(imageName);
        hotelService.saveHotel(h);
        m.addAttribute("title", "Add Hotel");
        m.addAttribute("message","Hotel add successful");
        return "redirect:/h-form";
    }

    @RequestMapping("/im/{filename}")
    public ResponseEntity<?> uploadImage(@PathVariable String file) throws IOException {
        byte [] imdb = storageService.downloadImage(file);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imdb);
    }


    @RequestMapping("/hotel_list")
    public  String hotelList(Model m){
        m.addAttribute("hotelList", hotelService.getAllHotel());
        m.addAttribute("locationList", locationService.getAllLocation());
        m.addAttribute("hFaciList", hotelFacilitiesService.getALlHFacilities());
        return "hotellist";
    }

//    @RequestMapping("/{fileName}")
//    public ResponseEntity<?> downloadImage(@RequestParam("fileName")String fileName){
//        System.out.println("===="+fileName);
//        byte[] imageData=storageService.downloadImage(fileName);
//        return ResponseEntity.status(HttpStatus.OK)
//                .contentType(MediaType.valueOf("image/png"))
//                .body(imageData);
//    }


    @RequestMapping("/update_hotel/{hid}")
    public String updateHotel(@PathVariable("hid") Integer hid, Model m){
        Hotel h = hotelService.findHotelById(hid);
        m.addAttribute("hotel", h);
        m.addAttribute("locationList", locationService.getAllLocation());
        m.addAttribute("hFaciList", hotelFacilitiesService.getALlHFacilities());
        return "hotel-form";
    }

    @RequestMapping("/delete_hotel/{hid}")
    public String deleteHotel(@PathVariable("hid") Integer hid){
        hotelService.deleteHotelById(hid);
        return "redirect:/hotel_list";
    }


//    @RequestMapping("/all-hotel")
//    public  String getAllHotel(){
//        System.out.println(iHotelRepo.findAllHotel());
//
//        return "Hello";
//    }

    @RequestMapping(value = "/hotel-by-location/", method = RequestMethod.POST)
    public  String getHotelByLid(@ModelAttribute("hotel")Hotel h, Model m, @Param("lid") String lid){
//        m.addAttribute("location", new Location());
        m.addAttribute("lid", lid);
        int locId= Integer.parseInt(lid);
        System.out.println(lid+"++++++++++++++++++");

        m.addAttribute("hotelList", iHotelRepo.findHotelByLocationId(locId));
        System.out.println(iHotelRepo.findHotelByLocationId(locId));
        m.addAttribute("locationList", locationService.getAllLocation());

        return "user-index";
    }

}
