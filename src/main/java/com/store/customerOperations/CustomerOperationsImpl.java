package com.store.customerOperations;

import com.store.exceptions.ProductNotInStockException;
import com.store.exceptions.ProductOutOfStockException;
import com.store.models.Customer;
import com.store.models.Product;
import com.store.models.Store;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

public class CustomerOperationsImpl implements CustomerOperations{

    @Override
    public Map<Product, Integer> addProductToCart(Customer customer, Store store, String productName, int quantityWanted) throws ProductOutOfStockException, ProductNotInStockException {
//        for (Product product : store.getProductList()) { //
        for (int i=0; i< store.getProductList().length; i++) { //
            if (store.getProductList()[i].getProductName().equalsIgnoreCase(productName)) {
                if (store.getProductList()[i].getProductQuantity() > quantityWanted) {
                    System.out.println("current product --> "+ store.getProductList()[i]);
                    customer.getCartMap().merge(store.getProductList()[i], quantityWanted, Integer::sum);

                    break;
                } else {
                    throw new ProductNotInStockException("Your request is ssds");
                }
//            } else {
//                throw new ProductOutOfStockException("Out of Stock");
            }
        }
        return customer.getCartMap();
    }

    @Override
    public void loadCustomerAccount(Customer customer, double amount) {
        double originalBalance = customer.getAccount().getAccountBalance();
        customer.getAccount().setAccountBalance(originalBalance+amount);
    }
}
