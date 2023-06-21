package org.idb.Tourism.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id   // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto_increment
    private int id;
    @Column(length = 45,unique = true)
    private String email;
    @Column(length = 64) // Encrypted mode with 64 charecter
    private String password;
    @Column(length = 30)
    private String firstname;
    @Column(length = 30)
    private String lastname;
    @Column(length = 30)
    private String cell;

//    @Column(length = 64)
//    private String photo;
//    private boolean isEnabled=false;
//
//    @ManyToMany
//    @JoinTable(
//            name = "user_roles",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_is")
//    )
//    private Set<Role> roles=new HashSet<>();
//
//
//    public User(String email, String password, String firstName, String lastName) {
//        this.email = email;
//        this.password = password;
//        this.firstName = firstName;
//        this.lastName = lastName;
//    }
//
//    public void  addRole(Role role){
//        this.roles.add(role);
//    }
}
