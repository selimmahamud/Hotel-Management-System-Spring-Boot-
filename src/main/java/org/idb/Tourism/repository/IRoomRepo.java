package org.idb.Tourism.repository;

import org.idb.Tourism.entity.Hotel;
import org.idb.Tourism.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRoomRepo extends JpaRepository<Room, Integer> {

    @Query("select r from Room r where r.hotel.hid=?1")
    public List<Room> findRoomByHotelId(int id);


//    @Query(value = "select * from Room r where r.hid_fk = :hid and r.rstatus = 1", nativeQuery = true)
//    public List<Room> findRoomByHotelId(@Param("hid") int id);
}
