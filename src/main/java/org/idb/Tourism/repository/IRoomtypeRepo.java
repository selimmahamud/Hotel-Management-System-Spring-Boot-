package org.idb.Tourism.repository;

import org.idb.Tourism.entity.Roomtype;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoomtypeRepo extends JpaRepository<Roomtype, Integer> {
}
