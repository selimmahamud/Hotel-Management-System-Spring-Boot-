package org.idb.Tourism.restcontroller;

import org.idb.Tourism.entity.Location;
import org.idb.Tourism.entity.RoomFacilities;
import org.idb.Tourism.entity.Roomtype;
import org.idb.Tourism.service.RoomtypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
public class RoomtypeRestController {

    @Autowired
    RoomtypeService roomtypeService;

    //    working on postman
    @GetMapping("/roomtype/all")
    public List<Roomtype> roomtypeForm(){
        return roomtypeService.getAllRoomtype();
    }

    //    working on postman
    @PostMapping("/roomtype/add")
    public  void roomtypeAdd(@RequestBody  Roomtype rt){
        roomtypeService.saveRoomtype(rt);
    }

    //    working on postman
    @DeleteMapping("/roomtype/delete/{rtid}")
    public  void deleteroomtype(@PathVariable("rtid") Integer rtid){
        roomtypeService.deleteRoomtype(rtid);
    }


    //    working on postman
    @PutMapping("/roomtype/update/{rtid}")
    public void updateRoomtype(@RequestBody Roomtype rt, @PathVariable("rtid") Integer rtid){
        roomtypeService.update(rt, rtid);
    }

    @GetMapping("/roomtype/{rtid}")
    public Roomtype getRoomtypeById(@PathVariable("rtid") int rtid){
        return roomtypeService.findRoomtypeById(rtid);
    }






}
