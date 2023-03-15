package com.caalm.user.services.interfaces;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface FileUpload {
    String uploadProfilePic(MultipartFile multipartFile) throws IOException;
}
