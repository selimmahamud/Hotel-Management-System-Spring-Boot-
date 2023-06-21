package org.idb.Tourism.repository;

import org.idb.Tourism.entity.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StorageRepository extends JpaRepository<ImageData, Long> {
    Optional<ImageData> findByName(String fileName);

//    @Query("select Imgd from ImageData imgd where imgd.name = ?1")
//    public ImageData xx(String fileName);

}
