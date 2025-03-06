package com.shopsnap.shopsnap.service.impl;

import com.shopsnap.shopsnap.model.Product;
import com.shopsnap.shopsnap.payload.ProductDto;
import com.shopsnap.shopsnap.repository.ProductRepository;
import com.shopsnap.shopsnap.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImplementation implements ProductService {

    @Autowired
   private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;


    public List<ProductDto> getAllProducts(){
        List<Product> productList = this.productRepository.findAll();
        List<ProductDto> productDtoList = productList.stream().map(product -> this.productToProductDto(product)).collect(Collectors.toList());
        return productDtoList;
    }

    private ProductDto productToProductDto(Product product){
        return this.modelMapper.map(product,ProductDto.class);
    }

    private  Product productDtoToProduct(ProductDto productDto){
        return this.modelMapper.map(productDto, Product.class);
    }
}
