package org.idb.Tourism.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int lid;

    @Column(length = 60)
    String lname;

    @Column(length = 60)
    String lzipcode;

    @Column(length = 60)
    String llat;

    @Column(length = 60)
    String llong;

    @Column(length = 60)
    String lcountry;

    @Column(length = 60)
    String ldescription;

    @Column(length = 60)
    String lphoto;


}
