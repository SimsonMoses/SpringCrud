package com.mindgraph.controller;

import com.mindgraph.enumeration.ResponseStatus;
import com.mindgraph.request.CreateUser;
import com.mindgraph.response.CommonResponse;
import com.mindgraph.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("createUser")
    public CommonResponse createUser(@Validated @RequestBody CreateUser createUser){
        CommonResponse response = new CommonResponse();
        try{
            response = userService.createUser(createUser);
        }catch (Exception ex){
            response.setCode(500);
            response.setStatus(ResponseStatus.FAILED);
            response.setData(ex.getMessage());
            response.setErrorMessage("Something went wrong. Please try again later");
        }
        return response;
    }

}
