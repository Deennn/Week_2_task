package com.store.models;

public class Category {
    private java.lang.String CategoryName;


    public Category(java.lang.String categoryName) {
        CategoryName = categoryName;

    }

    public java.lang.String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(java.lang.String categoryName) {
        CategoryName = categoryName;
    }



    @Override
    public java.lang.String toString() {
        return "Category{" +
                "CategoryName='" + CategoryName + '\'' +
                '}';
    }
}
