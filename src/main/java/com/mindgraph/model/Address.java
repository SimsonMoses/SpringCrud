package com.mindgraph.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Table(name = "address")
@Entity
@ToString
@Data
public class Address {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long addressId;
    @OneToOne
    @JoinColumn(referencedColumnName = "userId")
    private User userId;
    @Column(name = "door_no")
    private String doorNo;
    @Column(name = "street_name",length = 30)
    private String streetName;
    @Column(name = "land_mark",length = 30)
    private String landMark;
    @Column(name = "district",length = 25)
    private String district;
    @Column(length = 6)
    private int pincode;
    @Column(length = 25)
    private String state;
    @Column(length = 25)
    private String country;
    @ManyToOne
    @JoinColumn(name = "id")
    private User user;
}
