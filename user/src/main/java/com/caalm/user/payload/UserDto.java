package com.caalm.user.payload;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

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
    @Size(min=4,message="Username Must be Unique And More Than 4 Character")
    private String userName;
    @Indexed(unique = true)
    private Integer registrationNo;
    private String fullName;
    private String hostelName;
    private String departmentName;
    private String course;
    private String avatar;
    @Email(message="Email not valid")
    private String email;
    private String insta; 
    @Indexed(unique = true)
    @Size(min = 10,max=10, message="Number Should Contain 10 Character")
    private String mobileNum;
}

