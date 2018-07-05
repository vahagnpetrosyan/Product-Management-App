package com.products.products.utils;

import com.products.products.entities.ProductEntity;
import com.products.products.dtos.ProductDto;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class ProductMapper {

    public  ProductDto toDto(ProductEntity productEntity){
        if(productEntity == null){
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setId(productEntity.getId());
        productDto.setProductName(productEntity.getProductName());
        productDto.setProductCode(productEntity.getProductCode());
        productDto.setDescription(productEntity.getDescription());
        productDto.setPrice(productEntity.getPrice());
        productDto.setStarRating(productEntity.getStarRating());
        productDto.setImageUrl(productEntity.getImageUrl());

        if(productEntity.getReleaseDate() != null){
            LocalDate releaseDate = productEntity.getReleaseDate().toLocalDate();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            productDto.setReleaseDate(releaseDate.format(formatter));
        }

        return productDto;
    }

    public ProductEntity toEntity(ProductDto productDto){
        if(productDto == null){
            return null;
        }

        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(productDto.getId());
        productEntity.setProductName(productDto.getProductName());
        productEntity.setProductCode(productDto.getProductCode());
        productEntity.setDescription(productDto.getDescription());
        productEntity.setPrice(productDto.getPrice());
        productEntity.setStarRating(productDto.getStarRating());
        productEntity.setImageUrl(productDto.getImageUrl());

        if(productDto.getReleaseDate() != null){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.parse(productDto.getReleaseDate(), formatter);
            productEntity.setReleaseDate(Date.valueOf(localDate));
        }

        return productEntity;
    }

    public List<ProductDto> toListDto(Collection<ProductEntity> entities){
        List<ProductDto> productDtos = new ArrayList<>();
        entities.stream().map(this::toDto).forEach(productDtos::add);

        return productDtos;
    }

    public List<ProductEntity> toListEntity(Collection<ProductDto> dtos){
        List<ProductEntity> productEntities = new ArrayList<>();
        dtos.stream().map(this::toEntity).forEach(productEntities::add);

        return productEntities;
    }

}
