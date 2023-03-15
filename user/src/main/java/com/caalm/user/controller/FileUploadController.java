package com.caalm.user.controller;

import java.io.IOException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.caalm.user.exception.ResourceNotFound;
import com.caalm.user.model.User;
import com.caalm.user.repository.UserRepository;
import com.caalm.user.services.interfaces.FileUpload;

@RestController
public class FileUploadController {

    @Autowired
    private FileUpload fileUpload; 

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/home")
    String home(){
        return "Home sweet home";
    }
    @PostMapping("/upload/{mobileNo}")
    public ResponseEntity<String> uploadProfilePic(@RequestParam("multipartFile") MultipartFile multipartFile, @PathVariable String mobileNo) throws IOException{

       
        

        if(multipartFile.isEmpty()){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request Must Contain File");
        }

        if (!multipartFile.getContentType().equals("image/jpg")) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Must be a jpg file");  
        }
        String profileUrl=this.fileUpload.uploadProfilePic(multipartFile);
        User user= this.userRepository.findByMobileNum(mobileNo);
        if(user==null){
            throw new ResourceNotFound("User", "mobile", mobileNo);
        }
        user.setAvatar(profileUrl);
        User updatedUser= this.userRepository.save(user);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Uploaded Sucessfully") ;
    }
    
}
