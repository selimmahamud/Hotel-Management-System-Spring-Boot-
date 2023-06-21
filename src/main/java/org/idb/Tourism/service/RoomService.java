package org.idb.Tourism.service;

import org.idb.Tourism.entity.Room;
import org.idb.Tourism.entity.Roomtype;
import org.idb.Tourism.repository.IRoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    IRoomRepo iRoomRepo;
    public  void  saveRoom(Room r){
        iRoomRepo.save(r);
    }

    public void deleteRoomById(int rid){
        iRoomRepo.deleteById(rid);

    }

    public List<Room> getAllRoom(){

        return iRoomRepo.findAll();
    }

    public  Room findRoomById(int rid){
        return iRoomRepo.findById(rid).get();
    }

    public void update(Room r, int id){
        iRoomRepo.save(r);

    }


}
