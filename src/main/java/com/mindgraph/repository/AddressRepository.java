package com.mindgraph.repository;

import com.mindgraph.model.Address;
import com.mindgraph.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Long> {
    List<Address> findByUser(User user);
}
