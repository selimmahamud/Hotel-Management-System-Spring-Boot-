package org.idb.Tourism.service;


import org.idb.Tourism.entity.Location;
import org.idb.Tourism.entity.Room;
import org.idb.Tourism.repository.ILocationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    @Autowired
    ILocationRepo lRepo;

    public  void  saveLocation(Location l){
        lRepo.save(l);
    }

    public void deleteLocationById(int lid){
        lRepo.deleteById(lid);
    }

    public List<Location> getAllLocation(){

        return lRepo.findAll();
    }

    public void update(Location l, int id){
        lRepo.save(l);
    }

    public  Location findLocationById(int lid){
        return lRepo.findById(lid).get();
    }
}
