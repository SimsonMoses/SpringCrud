package com.mindgraph.controller;

import com.mindgraph.enumeration.ResponseStatus;
import com.mindgraph.request.CreateAddress;
import com.mindgraph.response.CommonResponse;
import com.mindgraph.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("address")
public class AddressController {

    @Autowired
    private AddressService addressService;
    @PostMapping("createAddressForUser")
    public CommonResponse createAddressForUser(@RequestParam Long userId, @RequestBody CreateAddress createAddress){
        CommonResponse response = new CommonResponse();
        try{
            response = addressService.createAddressForUser(userId,createAddress);
        }catch (Exception ex){
            response.setCode(500);
            response.setStatus(ResponseStatus.FAILED);
            response.setData(ex.getMessage());
            response.setErrorMessage("Something went wrong. Please try again later");
        }
        return response;
    }
}
