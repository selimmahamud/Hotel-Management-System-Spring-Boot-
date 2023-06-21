package org.idb.Tourism.service;


import org.idb.Tourism.entity.HotelFacilities;
import org.idb.Tourism.entity.RoomFacilities;
import org.idb.Tourism.repository.IRoomFacilitiesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class RoomFacilitiesService {

    @Autowired
    IRoomFacilitiesRepo roomFacilitiesRepo;


    public  void  saveRoomFacilities(RoomFacilities roomFacilities){

        roomFacilitiesRepo.save(roomFacilities);
    }

    public void deleteRoomFacilitiesById(int rfid){
        roomFacilitiesRepo.deleteById(rfid);
    }


    public List<RoomFacilities> getAllRoomFacilities(){
        return roomFacilitiesRepo.findAll();
    }

    public void update(RoomFacilities rf, int id){
        roomFacilitiesRepo.save(rf);
    }

    public RoomFacilities findRoomFacilitiesById(int id){
        return roomFacilitiesRepo.findById(id).get();
    }


    public RoomFacilities getHotelFacilitiesBylId(int id){
        return  roomFacilitiesRepo.findById(id).get();
    }



}
