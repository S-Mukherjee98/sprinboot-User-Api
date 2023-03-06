package com.caalm.user.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateDto {
    
    private Integer registrationNo;
    private String fullName;
    private String departmentName;
    private String course;
    private String hostelName;
    private String email;
    private String insta;
    
}
