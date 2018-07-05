package com.products.products.services;

import com.products.products.repositories.ProductRepositoty;
import com.products.products.entities.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

     @Autowired private ProductRepositoty productRepositoty;

     @Transactional
     public void update(ProductEntity productEntity){
         productRepositoty.update(productEntity);
     }

     @Transactional
     public ProductEntity create(ProductEntity productEntity){
        return productRepositoty.create(productEntity);
     }

     @Transactional
     public void delete(Integer id){
         productRepositoty.delete(id);
     }

     public List<ProductEntity> findAll(){
         return productRepositoty.findAll();
     }

     public ProductEntity findOneById(Integer id){
         return productRepositoty.findOneById(id);
     }

}
