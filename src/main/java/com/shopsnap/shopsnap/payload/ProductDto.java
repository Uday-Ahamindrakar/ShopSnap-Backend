package com.shopsnap.shopsnap.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {


    private int product_id;

    private String product_imageUrl;

    private String product_title;

    private String product_description;

    private int product_price;
}
