package com.mindgraph.service.impl;

import com.mindgraph.enumeration.ResponseStatus;
import com.mindgraph.model.User;
import com.mindgraph.repository.UserRepository;
import com.mindgraph.request.CreateUser;
import com.mindgraph.response.CommonResponse;
import com.mindgraph.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public CommonResponse createUser(CreateUser createUser) {
        CommonResponse response = new CommonResponse();
        boolean doesUserExist = userRepository.existsByUserPhoneNumberOrUserEmail(createUser.getUserPhoneNumber(), createUser.getUserEmail());
        if (!doesUserExist) {
            User user = modelMapper.map(createUser, User.class);
            userRepository.save(user);
            response.setCode(200);
            response.setStatus(ResponseStatus.SUCCESS);
            response.setSuccessMessage("User has created successfully");
            response.setData(createUser);
        } else {
            response.setCode(409);
            response.setStatus(ResponseStatus.FAILED);
            response.setErrorMessage("User with phone or email already exists!");
            response.setData(createUser);
        }
        return response;
    }
}
