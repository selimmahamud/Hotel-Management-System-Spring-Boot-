package org.idb.Tourism.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int bid;

    @Column(length = 60)
    private LocalDateTime bdatetime;

    @Column(length = 60)
    private String checkin;

    @Column(length = 60)
    private String checkout;

    @Column(length = 60)
    private String location;

    @Column(length = 60)
    private String hotelname;

    @Column(length = 60)
    private String hoteladdress;

    @Column(length = 60)
    private int roomnumber;

    @Column(length = 60)
    private String customarname;

    @Column(length = 60)
    private String email;

    @Column(length = 60)
    private String cell;

    private Double price;
}
