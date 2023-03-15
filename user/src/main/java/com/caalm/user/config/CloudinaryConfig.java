package com.caalm.user.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;

@Configuration
public class CloudinaryConfig {

    private final String CLOUD_NAME="dfucizco3" ;
    private final String API_KEY="497758818875749";
    private final String API_SECRET="f4S2Uua-pW8gSSqq3Vg1UD_f9Gg";


    @Bean
    public Cloudinary cloudinary(){

        Map<String,String> config=new HashMap<>();
        config.put("cloud_name", CLOUD_NAME);
        config.put("api_key", API_KEY);
        config.put("api_secret", API_SECRET);
        return new Cloudinary(config);
    }
    
}
