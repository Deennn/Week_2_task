package com.store.models;


public class Product {
    private static int productIdTracker = 0;

    private String productName, productDescription;
    private Category category;
    private String productId;
    private double productPrice;
    private int productQuantity;

    public Product(String productName,String productDescription,Category category, double productPrice,int productQuantity) {
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
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
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", category=" + category +
                ", productId='" + productId + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }
}
