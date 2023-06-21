package org.idb.Tourism.repository;

import org.idb.Tourism.entity.HotelFacilities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHotelFacilitiesRepo extends JpaRepository<HotelFacilities, Integer> {


}
