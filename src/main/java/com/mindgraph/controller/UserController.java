package com.mindgraph.controller;

import com.mindgraph.enumeration.ResponseStatus;
import com.mindgraph.model.User;
import com.mindgraph.request.CreateUser;
import com.mindgraph.response.CommonResponse;
import com.mindgraph.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("getAllUsers")
    public CommonResponse getAllUsers(){
        CommonResponse response = new CommonResponse();
        try{
            response = userService.getAllUsers();
        }catch (Exception ex){
            response.setCode(500);
            response.setStatus(ResponseStatus.FAILED);
            response.setData(ex.getMessage());
            response.setErrorMessage("Something went wrong. Please try again later");
        }
        return response;
    }

    @GetMapping("getUserByEmail")
    public CommonResponse getUserByUserEmail(@RequestParam String userEmail){
        CommonResponse response = new CommonResponse();
        try{
            response = userService.getUserByUserEmail(userEmail);
        }catch (Exception ex){
            response.setCode(500);
            response.setStatus(ResponseStatus.FAILED);
            response.setData(ex.getMessage());
            response.setErrorMessage("Something went wrong. Please try again later");
        }
        return response;
    }

    @GetMapping("getUserByPhoneNumber")
    public CommonResponse getUserByPhoneNumber(@RequestParam int userPhoneNumber){
        CommonResponse response = new CommonResponse();
        try{
            response = userService.getUserByPhoneNumber(userPhoneNumber);
        }catch (Exception ex){
            response.setCode(500);
            response.setStatus(ResponseStatus.FAILED);
            response.setData(ex.getMessage());
            response.setErrorMessage("Something went wrong. Please try again later");
        }
        return response;
    }

    @PutMapping("updateUser")
    public CommonResponse updateUser(@RequestBody User user){
        CommonResponse response = new CommonResponse();
        try{
            response = userService.updateUser(user);
        }catch (Exception ex){
            response.setCode(500);
            response.setStatus(ResponseStatus.FAILED);
            response.setData(ex.getMessage());
            response.setErrorMessage("Something went wrong. Please try again later");
        }
        return response;
    }
}
