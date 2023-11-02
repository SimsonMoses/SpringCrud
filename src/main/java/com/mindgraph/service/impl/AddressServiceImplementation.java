package com.mindgraph.service.impl;

import com.mindgraph.enumeration.ResponseStatus;
import com.mindgraph.model.Address;
import com.mindgraph.repository.AddressRepository;
import com.mindgraph.repository.UserRepository;
import com.mindgraph.request.CreateAddress;
import com.mindgraph.response.CommonResponse;
import com.mindgraph.service.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImplementation implements AddressService {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CommonResponse createAddressForUser(Long userId, CreateAddress createAddress) {
        CommonResponse response = new CommonResponse();
        boolean isUserExists = userRepository.existsById(userId);
        if (isUserExists) {
            Address address = modelMapper.map(createAddress, Address.class);
            addressRepository.save(address);
            response.setCode(200);
            response.setStatus(ResponseStatus.SUCCESS);
            response.setSuccessMessage("Address has been created successfully");
            response.setData(createAddress);
        } else {
            response.setCode(404);
            response.setStatus(ResponseStatus.FAILED);
            response.setErrorMessage("User doesn't Exists!");
            response.setData(userId);
        }
        return response;
    }
}