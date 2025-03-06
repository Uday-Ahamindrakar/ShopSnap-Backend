package com.shopsnap.shopsnap.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    String email;
    String name;
    String mobileNo;
    String password;
    String address;
}
