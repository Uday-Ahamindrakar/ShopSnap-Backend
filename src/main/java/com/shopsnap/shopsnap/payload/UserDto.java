package com.shopsnap.shopsnap.payload;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @NotBlank(message = "Email cannot be blank")
    private String email;
    @NotNull
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, message = "Name must be at least 2 characters long")
    private String name;
    @NotNull
    @NotBlank(message = "Mobile number cannot be blank")
    private String mobileNo;
    @NotNull
    @NotBlank(message = "Password cannot be blank")
    private String password;
    @NotNull
    @NotBlank(message = "Address cannot be blank")
    private String address;
}
