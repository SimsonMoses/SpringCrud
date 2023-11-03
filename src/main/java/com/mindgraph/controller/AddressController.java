package com.mindgraph.controller;

import com.mindgraph.enumeration.ResponseStatus;
import com.mindgraph.model.Address;
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
    public CommonResponse createAddressForUser(@RequestBody CreateAddress createAddress) {
        CommonResponse response = new CommonResponse();
        try {
            response = addressService.createAddressForUser(createAddress);
        } catch (Exception ex) {
            response.setCode(500);
            response.setStatus(ResponseStatus.FAILED);
            response.setData(ex.getMessage());
            response.setErrorMessage("Something went wrong. Please try again later");
        }
        return response;
    }

    @GetMapping("getAddressByUserId")
    public CommonResponse getAddressByUserId(@RequestParam Long userId) {
        CommonResponse response = new CommonResponse();
        try {
            response = addressService.getAddressByUserId(userId);
        } catch (Exception ex) {
            response.setCode(500);
            response.setStatus(ResponseStatus.FAILED);
            response.setData(ex.getMessage());
            response.setErrorMessage("Something went wrong. Please try again later");
        }
        return response;
    }

    @PutMapping("updateAddress")
    public CommonResponse updateAddress(@RequestBody Address address) {
        CommonResponse response = new CommonResponse();
        try {
            response = addressService.updateAddress(address);
        } catch (Exception ex) {
            response.setCode(500);
            response.setStatus(ResponseStatus.FAILED);
            response.setData(ex.getMessage());
            response.setErrorMessage("Something went wrong. Please try again later");
        }
        return response;
    }

    @DeleteMapping("deleteAddressById")
    public CommonResponse deleteAddressById(@RequestParam Long addressId) {
        CommonResponse response = new CommonResponse();
        try {
            response = addressService.deleteAddressById(addressId);
        } catch (Exception ex) {
            response.setCode(500);
            response.setStatus(ResponseStatus.FAILED);
            response.setData(ex.getMessage());
            response.setErrorMessage("Something went wrong. Please try again later");
        }
        return response;
    }
}
