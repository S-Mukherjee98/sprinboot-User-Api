package com.caalm.user.services;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.caalm.user.exception.ResourceNotFound;
import com.caalm.user.model.User;
import com.caalm.user.payload.UserDto;
import com.caalm.user.repository.UserRepository;
import com.caalm.user.services.interfaces.FileUpload;
import com.cloudinary.Cloudinary;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileUploadImpl implements FileUpload {

  


    private final Cloudinary cloudinary;


    @Override
    public String uploadProfilePic(MultipartFile multipartFile) throws IOException {
        // TODO Auto-generated method stub

        String profileUrl;
        profileUrl= cloudinary.uploader().upload( multipartFile.getBytes(),Map.of("public_id",UUID.randomUUID().toString())).get("url").toString();
        return profileUrl;
    }
    
    
}



/*
 * cloudinary.uploader().upload("sample.jpg", 
  ObjectUtils.asMap(
    "folder", "mypath1/mypath2/", 
    "public_id", "my_name"));
 */
