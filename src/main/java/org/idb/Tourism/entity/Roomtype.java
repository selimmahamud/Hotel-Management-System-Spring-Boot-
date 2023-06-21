package org.idb.Tourism.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Roomtype {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rtid;

    @Column(length = 30)
    private  String rtName;

    @Column(length = 250)
    private  String rtDescription;

    @Column(length = 30)
    private  String rtKey;

}
