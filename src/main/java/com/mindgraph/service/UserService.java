package com.mindgraph.service;

import com.mindgraph.request.CreateUser;
import com.mindgraph.response.CommonResponse;

public interface UserService {
    public CommonResponse createUser(CreateUser user);
}
