package com.mindgraph.service.impl;

import com.mindgraph.enumeration.ResponseStatus;
import com.mindgraph.model.Address;
import com.mindgraph.model.User;
import com.mindgraph.repository.AddressRepository;
import com.mindgraph.repository.UserRepository;
import com.mindgraph.request.CreateAddress;
import com.mindgraph.response.CommonResponse;
import com.mindgraph.service.AddressService;
import lombok.extern.log4j.Log4j2;
import org.hibernate.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class AddressServiceImplementation implements AddressService {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CommonResponse createAddressForUser(CreateAddress createAddress) {
        CommonResponse response = new CommonResponse();
        boolean isUserExists = userRepository.existsById(createAddress.getUserId());
        if (isUserExists) {
            Address address = modelMapper.map(createAddress, Address.class);
            Address save = addressRepository.save(address);
            log.info("Create Address: " + address);
            response.setCode(200);
            response.setStatus(ResponseStatus.SUCCESS);
            response.setSuccessMessage("Address has been created successfully");
            response.setData(createAddress);
        } else {
            response.setCode(404);
            response.setStatus(ResponseStatus.FAILED);
            response.setErrorMessage("User doesn't Exists!");
            response.setData(createAddress.getUserId());
        }
        return response;
    }

    @Override
    public CommonResponse getAddressByUserId(Long userId) {
        CommonResponse response = new CommonResponse();
        User user = userRepository.findById(userId).orElseThrow(() -> new ObjectNotFoundException("Data not found", new User()));
        List<Address> addressRelatedToUser = addressRepository.findByUser(user);
        if (user != null && !addressRelatedToUser.isEmpty()) {
            response.setCode(200);
            response.setStatus(ResponseStatus.SUCCESS);
            response.setSuccessMessage("Address has been created successfully");
            response.setData(addressRelatedToUser);
        } else {
            response.setCode(404);
            response.setStatus(ResponseStatus.FAILED);
            response.setErrorMessage("User doesn't have the Address");
            response.setData(userId);
        }
        return response;
    }

    @Override
    public CommonResponse deleteAddressByAddressId(Long addressId) {
        CommonResponse response = new CommonResponse();
        boolean isAddressExist = addressRepository.existsById(addressId);
        if (isAddressExist) {
            addressRepository.deleteById(addressId);
            response.setCode(200);
            response.setStatus(ResponseStatus.SUCCESS);
            response.setSuccessMessage("Address has been deleted Successfully");
            response.setData(addressId);
        } else {
            response.setCode(404);
            response.setStatus(ResponseStatus.FAILED);
            response.setSuccessMessage("Address doesn't exists!!");
            response.setData(addressId);
        }
        return response;
    }
}