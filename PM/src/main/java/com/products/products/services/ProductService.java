package com.products.products.services;

import com.products.products.entities.ProductEntity;
import com.products.products.exceptionhandling.exceptions.ProductNotFoundException;
import com.products.products.repositories.ProductRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

     @Autowired private ProductRepositoty productRepositoty;

     public void update(ProductEntity productEntity){
         productRepositoty.update(productEntity);
     }

     public ProductEntity create(ProductEntity productEntity){
        return productRepositoty.create(productEntity);
     }

     public void delete(Integer id){
         productRepositoty.delete(id);
     }

     public List<ProductEntity> findAll(){
         return productRepositoty.findAll();
     }

     public ProductEntity findOneById(Integer id){
         try {
             return productRepositoty.findOneById(id);
         }
         catch (EmptyResultDataAccessException ex){
             throw new ProductNotFoundException("Product with id: " + id + " is not found");
         }
     }

}
