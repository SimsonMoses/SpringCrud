package com.mindgraph.request;

import com.mindgraph.model.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateAddress {
    private Long userId;
    private String doorNo;
    private String streetName;
    private String landMark;
    private String district;
    private int pincode;
    private String state;
    private String country;
}
