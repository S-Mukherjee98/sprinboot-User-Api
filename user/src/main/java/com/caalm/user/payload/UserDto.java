package com.caalm.user.payload;

import org.springframework.data.mongodb.core.index.Indexed;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
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

