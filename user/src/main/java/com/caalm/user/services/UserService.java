package com.caalm.user.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.caalm.user.exception.ResourceNotFound;
import com.caalm.user.model.User;
import com.caalm.user.payload.UserDto;
import com.caalm.user.payload.UserUpdateDto;
import com.caalm.user.repository.UserRepository;
import com.mongodb.DuplicateKeyException;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    //create User

    public UserDto createUser(UserDto userDto){
       
        User   user=this.modelMapper.map(userDto, User.class);
        
            User usr=this.userRepository.save(user);
            UserDto usrdto= this.modelMapper.map(usr, UserDto.class);
            return usrdto;
            
        
        
    }
//Get user all user info

    public List<UserDto> getAllUserInfo(){
        List<User> user= this.userRepository.findAll();
        List<UserDto> userdto= user.stream().map(user1->this.modelMapper.map(user1, UserDto.class)).collect(Collectors.toList());
        return userdto;
    }

//Get user by phone number

public UserDto getUserInfoByMobileNum(String mobilenNum){
 
        
    User user;
    user=this.userRepository.findByMobileNum(mobilenNum);
    if (user==null) {
        throw new ResourceNotFound("User", "mobile", mobilenNum);
    }

    UserDto userDto=this.modelMapper.map(user, UserDto.class);
    return userDto;
    
    
   
    
}


//update user

    public UserDto updateUserInfo(UserUpdateDto userDto, String mobile_numb){
        User user=this.userRepository.findByMobileNum(mobile_numb);

        if(user==null){
            throw new ResourceNotFound("User", "mobile", mobile_numb);
        }


        user.setFullName(userDto.getFullName());
        user.setDepartmentName(userDto.getDepartmentName());
        user.setCourse(userDto.getCourse());
        user.setHostelName(userDto.getHostelName());
        user.setRegistrationNo(userDto.getRegistrationNo());
        user.setEmail(userDto.getEmail());
        user.setInsta(userDto.getInsta());
        User updatedUser= this.userRepository.save(user);


        return this.modelMapper.map(updatedUser, UserDto.class);


    }

//delete user by user id

public void deleteUserByMobileNum(String mobileNum){
    User existinguser= this.userRepository.findByMobileNum(mobileNum);
    this.userRepository.deleteByMobileNum(mobileNum);
}

    
}
