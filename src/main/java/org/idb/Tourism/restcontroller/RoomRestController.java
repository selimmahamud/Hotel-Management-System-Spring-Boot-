package org.idb.Tourism.restcontroller;

import org.idb.Tourism.entity.ImageData;
import org.idb.Tourism.entity.Room;
import org.idb.Tourism.repository.IImgDataRepo;
import org.idb.Tourism.repository.IRoomRepo;
import org.idb.Tourism.repository.StorageRepository;
import org.idb.Tourism.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
public class RoomRestController {
    @Autowired
    RoomService roomService;

    @Autowired
    RoomtypeService roomtypeService;

    @Autowired
    RoomFacilitiesService roomFacilitiesService;

    @Autowired
    HotelService hotelService;

    @Autowired
    IRoomRepo iRoomRepo;

    @Autowired
    StorageService storageService;

    @Autowired
    IImgDataRepo iImgDataRepo;

    @Autowired
    StorageRepository storageRepository;

    String profileImage = "";

    @GetMapping("room/all")
    public List<Room> allRoom(){
        return roomService.getAllRoom();
    }

//    @GetMapping("/get_img_by_name/{imgName}")
//    public ImageData getImagname(@PathVariable("imgName")String imgName){
//        return storageRepository.xx(imgName);
//    }

    @GetMapping("/get_img")
    public List<ImageData> getImagByte(){
        return iImgDataRepo.findAll();
    }

    @GetMapping("/room/{rid}")
    public Room getRoomById(@PathVariable("rid") int rid){
        return roomService.findRoomById(rid);
    }

    @GetMapping("/roombyhotelid/{hid}")
    public List<Room> getRoomByHotelId(@PathVariable String hid){
        int hiid = Integer.parseInt(hid);
        System.out.println(hiid);
        return  iRoomRepo.findRoomByHotelId(hiid);
    }

    @PatchMapping("/room/dactive/{id}")
    public void dactiveRoom(@PathVariable String id){
        int rid = Integer.parseInt(id);
        Room r = roomService.findRoomById(rid);
        r.setRstatus(1);
        roomService.saveRoom(r);
    }

    @PatchMapping("/room/active/{id}")
    public void activeRoom(@PathVariable String id){
        int rid = Integer.parseInt(id);
        Room r = roomService.findRoomById(rid);
        r.setRstatus(0);
        roomService.saveRoom(r);
    }

    //     This is for add new room
    @PostMapping("/room/add")
    public  void roomAdd(@RequestBody Room r){
        r.setRgallery(profileImage);
        roomService.saveRoom(r);
    }

    @PostMapping(value = {"/uploadImg"}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public void uploadImg(@RequestPart("file") MultipartFile file) throws IOException {
        profileImage=storageService.uploadImage(file);
    }

    //    This is for delete room by id
    @DeleteMapping("/room/delete/{rid}")
    public  void deleteroom(@PathVariable("rid") Integer rid){
        roomService.deleteRoomById(rid);
    }


    //    working on postman
    @PutMapping("/room/update/{rid}")
    public void updateRoom(@RequestBody Room r, @PathVariable("rid") Integer rid){
        roomService.update(r, rid);
    }

    @GetMapping("/roombyid/{id}")
    public Room getRoomBylId(@PathVariable("id") int id){
        return  roomService.findRoomById(id);
    }




}
