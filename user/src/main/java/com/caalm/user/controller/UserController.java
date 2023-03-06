package com.caalm.user.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.caalm.user.model.User;
import com.caalm.user.payload.UserDto;
import com.caalm.user.payload.UserUpdateDto;
import com.caalm.user.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    ModelMapper modelMapper;
    

    @PostMapping

    ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto userDtoCreated= this.userService.createUser(userDto);
        return new ResponseEntity<UserDto>(userDtoCreated,HttpStatus.CREATED);
    }



    @GetMapping
    ResponseEntity<List<UserDto>>getAllUserInfo(){

        List<UserDto> userDto=this.userService.getAllUserInfo();
        return new ResponseEntity<List<UserDto>>(userDto,HttpStatus.OK);
    }

    @GetMapping("/mobile/{mobilenNum}")
    public ResponseEntity<UserDto> getUserInfoByMobileNum(@PathVariable(value = "mobilenNum") String mobileNum){
        UserDto userDto=this.userService.getUserInfoByMobileNum(mobileNum);
        return new ResponseEntity<UserDto>(userDto,HttpStatus.OK);
    }

    @PutMapping("/{mobileNum}")
    ResponseEntity<UserDto> updateUserInfo(@RequestBody UserUpdateDto userUpdatedDto, @PathVariable(value = "mobileNum") String mobileNum){

        UserDto updated= this.userService.updateUserInfo(userUpdatedDto, mobileNum);
        return new ResponseEntity<UserDto>(updated,HttpStatus.ACCEPTED);
    }
    
}