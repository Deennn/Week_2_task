package com.store.customerOperations;

import com.store.exceptions.ProductNotInStockException;
import com.store.exceptions.ProductOutOfStockException;
import com.store.models.Customer;
import com.store.models.Product;
import com.store.models.Store;

import java.util.Map;

public interface CustomerOperations {

   Map<Product,Integer> addProductToCart(Customer customer, Store store, String productName, int quantityWanted) throws ProductOutOfStockException, ProductNotInStockException;
//    void (Customer customer, Store store);
void loadCustomerAccount(Customer customer, double amount);
}
