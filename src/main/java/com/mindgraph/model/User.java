package com.mindgraph.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Table(name = "user")
@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long userId;
    @Column(name = "userFirstName", length = 30)
    private String userFirstName;
    private String userLastName;
    @Column(name = "userEmail", length = 40)
    private String userEmail;
    private String userGender;
    private Date dateOfBirth;
    @Column(length = 10)
    private int userPhoneNumber;
    private String userDepartment;
    private String userJoiningDate;
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Address> userAllAddress;
    @Override
    public String toString(){
        return "User to String";
    }
}