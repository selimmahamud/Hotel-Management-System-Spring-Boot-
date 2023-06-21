package org.idb.Tourism.restcontroller;

import org.idb.Tourism.entity.Hotel;
import org.idb.Tourism.entity.Location;
import org.idb.Tourism.repository.IHotelRepo;
import org.idb.Tourism.service.HotelFacilitiesService;
import org.idb.Tourism.service.HotelService;
import org.idb.Tourism.service.LocationService;
import org.idb.Tourism.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
public class HotelRestController {

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

    @PostMapping("/hotel/add")
    public void hotelSave(@RequestBody Hotel h){
        hotelService.saveHotel(h);
    }

    @GetMapping("/hotel/all")
    public List<Hotel> allHotel(){
        return iHotelRepo.findAllHotel();
    }


    @GetMapping("/hotel/{hid}")
    public Hotel getHotelById(@PathVariable("hid") int hid){;
        return hotelService.findHotelById(hid);
    }

    @GetMapping("/hotelbylocationid/{lid}")
    public List<Hotel> getHotelByLid(@PathVariable String lid){
        int lidcd = Integer.parseInt(lid);
        return  iHotelRepo.findHotelByLocationId(lidcd);
    }


    public ResponseEntity<?> downloadImage(@RequestParam("fileName")String fileName){
        System.out.println("===="+fileName);
        byte[] imageData=storageService.downloadImage(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);
    }


    public ResponseEntity<?> uploadImage(@PathVariable String file) throws IOException {
        byte [] imdb = storageService.downloadImage(file);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imdb);
    }

}
