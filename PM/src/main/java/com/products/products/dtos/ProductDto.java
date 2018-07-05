package com.products.products.dtos;

public class ProductDto {
    private int id;
    private String productName;
    private String productCode;
    private String releaseDate;
    private String description;
    private double price;
    private double starRating;
    private String imageUrl;

    public ProductDto() {}

    public ProductDto(int id, String productName, String productCode, String releaseDate, String description, double price, double starRating, String imageUrl) {
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

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
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

