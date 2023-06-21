package org.idb.Tourism.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rid;

    private int rstatus;

    @Column(length = 50)
    private String rnumber;

    @Column(length = 255)
    private String rdetails;

    private String rgallery; //for photos

    @Column(length = 50)
    private double rprice;

    @Column(length = 50)
    private double rdiscount;

    @Column(length = 50)
    private int radultcapacity;

    @Column(length = 50)
    private int rchildcapacity;

    @Column(length = 50)
    private int rtotalbed;

    @Column(length = 50)
    private double rsize;

    @ManyToOne
    @JoinColumn(name = "lid_fk")
    Location location;

    @ManyToOne
    @JoinColumn(name = "hid_fk")
    Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "rtid_fk")
    Roomtype roomtype;

    @ManyToOne
    @JoinColumn(name = "rfid_fk")
    RoomFacilities roomfacilities;
}
