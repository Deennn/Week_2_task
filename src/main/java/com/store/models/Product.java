package com.store.models;


public class Product {
    private static int productIdTracker = 0;

    private java.lang.String productName, productDescription;
    private Category category;
    private java.lang.String productId;
    private double productPrice;
    private int productQuantity;

    public Product(java.lang.String productName, java.lang.String productDescription, Category category, double productPrice, int productQuantity) {
        productIdTracker++;
        this.productName = productName;
        this.productDescription = productDescription;
        this.category = category;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
        if (productName.length() <= 1) {
            this.productId  = productName.substring(0) + productIdTracker;
        } else {
            this.productId  = productName.substring(0,2) + productIdTracker;
        }


    }

    public java.lang.String getProductName() {
        return productName;
    }

    public void setProductName(java.lang.String productName) {
        this.productName = productName;
    }

    public java.lang.String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(java.lang.String productDescription) {
        this.productDescription = productDescription;
    }

    public java.lang.String getProductId() {
        return productId;
    }

    public void setProductId(java.lang.String productId) {
        this.productId = productId;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    @Override
    public java.lang.String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", category=" + category +
                ", productId='" + productId + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }
}
