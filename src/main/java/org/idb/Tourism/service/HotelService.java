package org.idb.Tourism.service;

import org.idb.Tourism.entity.Hotel;
import org.idb.Tourism.repository.IHotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    @Autowired
    IHotelRepo hotelRepo;

    public  void  saveHotel(Hotel h){
        hotelRepo.save(h);
    }

    public void deleteHotelById(int hid){
        hotelRepo.deleteById(hid);

    }

    public List<Hotel> getAllHotel(){

        return hotelRepo.findAll();
    }

    public  Hotel findHotelById(int hid){
        return hotelRepo.findById(hid).get();
    }

    public List<Hotel> getHotelListByLocation(int id){

        return hotelRepo.findHotelByLocationId(id);
    }

}
