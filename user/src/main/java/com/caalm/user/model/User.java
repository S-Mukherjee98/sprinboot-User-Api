package com.caalm.user.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String userId;
    @Indexed(unique = true)
    private String userName;
    @Indexed(unique = true)
    private Integer registrationNo;
    private String fullName;
    private String hostelName;
    private String departmentName;
    private String course;
    private String avatar;
    private String email;
    private String insta;
    @Indexed(unique = true)
    private String mobileNum;

    
}
