package org.idb.Tourism.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomFacilities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int rfid;

    @Column(length = 55)
    private String rfname;

    @Column(length = 55)
    private String rfdescription;


}
