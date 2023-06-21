package org.idb.Tourism.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int hid;

    @Column(length = 60, nullable = false)
    private String hname;

    @Column(length = 255)
    private String hdescription;

    @Column(length = 255)
    private String haddress;

    @Column(length = 30)
    private String hfetcher;

    @Column(length = 30)
    private String hemail;

    @Column(length = 64)
    private String hpassword;

    @Column(length = 30)
    private String hphone;

    private String hwebsite;

    @Column(length = 30)
    private String haverageprice;

    @Column(length = 30)
    private String hcheckin;

    @Column(length = 30)
    private String hcheckout;

    @Column(length = 30)
    private String hpolicy;

    @Column(length = 30)
    private String hrating;

    private String hlogo;

    @Column(length = 40)
    private String hphoto;

    @ManyToOne
    @JoinColumn(name = "location_id")
    Location location;

    @ManyToOne
    @JoinColumn(name = "hotelFacilities_id")
    HotelFacilities hotelFacilities;


}
