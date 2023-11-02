package com.mindgraph.service;

import com.mindgraph.model.User;
import com.mindgraph.request.CreateUser;
import com.mindgraph.response.CommonResponse;

public interface UserService {
    public CommonResponse createUser(CreateUser user);
    public CommonResponse getAllUsers();
    public CommonResponse getUserByUserEmail(String userEmail);
    public CommonResponse getUserByPhoneNumber(int userPhoneNumber);
    public CommonResponse updateUser(User userUpdated);
    public CommonResponse deleteUser(Long userId);
}
