package com.store.customerOperations;

import com.store.exceptions.ProductNotInStockException;
import com.store.exceptions.ProductOutOfStockException;
import com.store.models.Category;
import com.store.models.Customer;
import com.store.models.Product;
import com.store.models.Store;

import java.util.List;
import java.util.Map;

public interface CustomerOperations {

   Map<Product,Integer> addProductToCart(Customer customer, Store store, java.lang.String productName, int quantityWanted) throws ProductOutOfStockException, ProductNotInStockException;
   List<Product> viewProductByCategory(Customer customer, Store store, String category) throws ProductNotInStockException;
   void loadCustomerAccount(Customer customer, double amount);
}
