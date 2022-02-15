package com.store.customerOperations;

import com.store.models.Customer;
import com.store.models.Product;
import com.store.models.Store;

import java.util.Map;

public interface CustomerOperations {

    Map<Product, Integer> addToCart(Customer customer, Store store, Product product, int quantityWanted, double wallet);
    void buyProduct(Customer customer, Store store);
}
