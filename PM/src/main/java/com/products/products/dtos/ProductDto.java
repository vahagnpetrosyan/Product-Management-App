package com.products.products.dtos;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class ProductDto {

    @NotNull
    private int id;

    @NotNull
    private String productName;

    @NotNull
    private String productCode;

    @NotNull
    private LocalDate releaseDate;

    @Size(max = 255)
    private String description;

    @NotNull
    @Positive
    private double price;

    @NotNull
    @Positive
    private double starRating;

    @Size(max = 255)
    private String imageUrl;

    public ProductDto() {}

    public ProductDto(int id, String productName, String productCode, LocalDate releaseDate,
                      String description, double price, double starRating, String imageUrl) {
        this.id = id;
        this.productName = productName;
        this.productCode = productCode;
        this.releaseDate = releaseDate;
        this.description = description;
        this.price = price;
        this.starRating = starRating;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getStarRating() {
        return starRating;
    }

    public void setStarRating(double starRating) {
        this.starRating = starRating;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "id='" + id + '\'' +
                ", productName='" + productName + '\'' +
                ", productCode='" + productCode + '\'' +
                ", releaseDate=" + releaseDate +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", starRating=" + starRating +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}

