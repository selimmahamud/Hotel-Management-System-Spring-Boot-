package org.idb.Tourism.repository;

import org.idb.Tourism.entity.RoomFacilities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IRoomFacilitiesRepo extends JpaRepository<RoomFacilities,Integer> {

}
