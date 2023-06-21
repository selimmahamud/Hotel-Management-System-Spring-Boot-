package org.idb.Tourism.service;


import org.idb.Tourism.entity.HotelFacilities;
import org.idb.Tourism.repository.IHotelFacilitiesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelFacilitiesService {

    @Autowired
    IHotelFacilitiesRepo hFrepo;

    public void saveHFacilities(HotelFacilities hf){
        hFrepo.save(hf);
    }

    public  void deleteHFacById(int hfacid){
        hFrepo.deleteById(hfacid);
    }

    public List<HotelFacilities> getALlHFacilities(){
        return  hFrepo.findAll();
    }

    public HotelFacilities findHFacById(int hfacid){
        return hFrepo.findById(hfacid).get();
    }

    public void updateHotelFacilities( HotelFacilities h, int id){
        hFrepo.save(h);
    }


}
