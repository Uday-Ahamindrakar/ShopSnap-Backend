package com.shopsnap.shopsnap.service;

import com.shopsnap.shopsnap.payload.ProductDto;

import java.util.List;

public interface ProductService {

    List<ProductDto> getAllProducts();
}
