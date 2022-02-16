package com.store.customerOperations;

import com.store.exceptions.ProductNotInStockException;
import com.store.exceptions.ProductOutOfStockException;
import com.store.models.Customer;
import com.store.models.Product;
import com.store.models.Store;

import java.util.Map;

public interface CustomerOperations {

    Map<Product, Integer> buyProduct(Customer customer, Store store, Product product, int quantityWanted, double wallet) throws ProductOutOfStockException, ProductNotInStockException;
//    void (Customer customer, Store store);
}
