package org.idb.Tourism.repository;

import org.idb.Tourism.entity.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IImgDataRepo extends JpaRepository<ImageData, Long> {
}
