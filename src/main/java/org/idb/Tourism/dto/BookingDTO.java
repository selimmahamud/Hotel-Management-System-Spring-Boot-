package org.idb.Tourism.dto;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
public class BookingDTO {


    private  int bid;

    private LocalDateTime bdatetime;

    private String checkin;

    private String checkout;

    private String location;

    private String hotelname;

    private String hoteladdress;

    private int roomnumber;

    private String customarname;

    private String email;

    private String cell;

    private Double price;
}
