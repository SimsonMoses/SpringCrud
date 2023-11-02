package com.mindgraph.request;

import lombok.Data;

import java.sql.Date;

@Data
public class CreateUser {
    private String userFirstName;
    private String userLastName;
    private String userEmail;
    private String userGender;
    private Date dateOfBirth;
    private int userPhoneNumber;
    private String userDepartment;
    private String userJoiningDate;
}
