package com.shopsnap.shopsnap.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue()
    private int product_id;

    @Column
    String product_imageUrl;

    @Column
    String product_title;

    @Column
    String product_description;

    @Column
    int product_price;


}
