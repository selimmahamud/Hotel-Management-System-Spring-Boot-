package org.idb.Tourism.restcontroller;

import org.idb.Tourism.entity.HotelFacilities;
import org.idb.Tourism.entity.Location;
import org.idb.Tourism.entity.Room;
import org.idb.Tourism.repository.IHotelFacilitiesRepo;
import org.idb.Tourism.service.HotelFacilitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
public class HotelFacilitiesRestController {

    @Autowired
    HotelFacilitiesService hotelFacilitiesService;

    @PostMapping("/hotelfacilities/add")
    public void HotelFacilitiesSave(@RequestBody HotelFacilities hf){
        hotelFacilitiesService.saveHFacilities(hf);
    }

    @GetMapping("/hotelfacilities/all")
    public List<HotelFacilities> allHotelFacilities(){
        return hotelFacilitiesService.getALlHFacilities();
    }

    @DeleteMapping("/hotelfacilities/delete/{id}")
    public void deleteFacilities(@PathVariable int id) {
        hotelFacilitiesService.deleteHFacById(id);
    }

    @PutMapping("/hotelfacilities/update/{id}")
    public void updateFacilities(@RequestBody HotelFacilities h, @PathVariable("id") int id) {
        hotelFacilitiesService.updateHotelFacilities(h, id);
    }
    @GetMapping("/hotelfacilities/{id}")
    public HotelFacilities getHotelFacilitiesBylId(@PathVariable("id") int id){
      return  hotelFacilitiesService.findHFacById(id);
    }
}
