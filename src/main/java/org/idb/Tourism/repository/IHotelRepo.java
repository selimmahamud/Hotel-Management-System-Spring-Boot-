package org.idb.Tourism.repository;

import org.idb.Tourism.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHotelRepo extends JpaRepository<Hotel, Integer>, JpaSpecificationExecutor<Hotel> {

    @Query("select h from Hotel h inner join h.location l on h.location.lid = l.lid")
    public List<Hotel> findAllHotel();

//
//    @Query("select h from Hotel h inner join h.location l on l.lid=h.hid where l.lid=?1")
//    public List<Hotel> findByLocationId(int id);

    @Query("select h from Hotel h where h.location.lid=?1")
    public List<Hotel> findHotelByLocationId(int id);




}
