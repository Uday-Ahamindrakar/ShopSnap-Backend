package com.shopsnap.shopsnap.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    private String email;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String mobileNo;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String address;

}
