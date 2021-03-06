package com.cybertek.dto;

import com.cybertek.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class UserDTO {

    private Long id;   // to assign manually an id as manager_id

    private String  firstName;
    private String  lastName;
    private String  userName;
    private String  passWord;
    private boolean  enabled;
    private String  phone;
    private RoleDTO  role;   //create Role DTO
    private Gender  gender;  // import
}
