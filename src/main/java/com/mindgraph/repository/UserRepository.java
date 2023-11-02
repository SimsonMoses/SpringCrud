package com.mindgraph.repository;


import com.mindgraph.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;

public interface UserRepository extends JpaRepository<User,Long> {

//    User findByUserFirstNameAndUserLastNameAndDateOfBirth(String userFirstName, String userLastName, Date dateOfBirth);

//    User findByUserPhoneNumberOrUserEmail(int userPhoneNumber, String userEmail);
    boolean existsByUserPhoneNumberOrUserEmail(int userPhoneNumber, String userEmail);
    User findByUserEmail(String userEmail);
    User findByUserPhoneNumber(int userPhoneNumber);
}
