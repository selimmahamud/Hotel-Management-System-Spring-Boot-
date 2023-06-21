package org.idb.Tourism.repository;

import org.idb.Tourism.entity.Booking;

import org.idb.Tourism.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookingRepo extends JpaRepository<Booking, Integer> {

    @Query("select max(b.bid) from Booking b")
    public Integer findMaxBookingId();

    @Query("select b From Booking b where b.bid = ?1")
    public Booking findBybookId(int id);


    @Query(value = "select b.bid, b.bdatetime, b.cell, b.checkin, b.checkout, b.customarname, b.email, b.hoteladdress, b.hotelname, b.location, b.roomnumber,  r.rprice price From tourism2.Booking b left join tourism2.room r on b.roomnumber = r.rnumber ", nativeQuery = true)
    List<Booking> getAllWithPrice();
}
