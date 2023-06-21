package org.idb.Tourism.repository;

import org.idb.Tourism.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ILocationRepo extends JpaRepository<Location, Integer> {


}
