package com.store.models;

public class Category {
    private String CategoryName;


    public Category(String categoryName) {
        CategoryName = categoryName;

    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }



    @Override
    public String toString() {
        return "Category{" +
                "CategoryName='" + CategoryName + '\'' +
                '}';
    }
}
