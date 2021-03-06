package com.products.products.controllers;

import com.products.products.dtos.ProductDto;
import com.products.products.services.ProductService;
import com.products.products.utils.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMapper productMapper;


    @GetMapping()
    public ResponseEntity<List<ProductDto>> getProducts(){
        return ResponseEntity.ok(productMapper.toListDto(productService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable String id){
        return ResponseEntity.ok(productMapper.toDto(productService.findOneById(Integer.parseInt(id))));
    }

    @PostMapping()
    public ResponseEntity<ProductDto> addProduct(@RequestBody @Valid ProductDto productDto){
        productDto.setId(ThreadLocalRandom.current().nextInt(0, 10));
        return
            new ResponseEntity<ProductDto>(productMapper
                                            .toDto(productService
                                            .create(productMapper.toEntity(productDto))),
                HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public void updateProduct(@RequestBody @Valid ProductDto productDto, @PathVariable Integer id){
        productDto.setId(id);
        productService.update(productMapper.toEntity(productDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable String id){
        productService.delete(Integer.parseInt(id));
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}

