package com.products.products.entities;

import java.sql.Date;
import java.sql.Timestamp;


public class ProductEntity {
    private Integer id;
    private String productName;
    private String productCode;
    private Date releaseDate;
    private String description;
    private Double price;
    private Double starRating;
    private String imageUrl;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public ProductEntity() {
        createdAt = new Timestamp(System.currentTimeMillis());
        updatedAt = new Timestamp(System.currentTimeMillis());
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "id='" + id + '\'' +
                ", productName='" + productName + '\'' +
                ", productCode='" + productCode + '\'' +
                ", releaseDate=" + releaseDate +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", starRating=" + starRating +
                ", imageUrl='" + imageUrl + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    public ProductEntity(Integer id, String productName, String productCode, Date releaseDate,
                         String description, double price, double starRating, String imageUrl,
                         Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.productName = productName;
        this.productCode = productCode;
        this.releaseDate = releaseDate;
        this.description = description;
        this.price = price;
        this.starRating = starRating;
        this.imageUrl = imageUrl;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Double getStarRating() {
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
}
