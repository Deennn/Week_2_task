package com.store.customerOperations;

import com.store.models.Customer;
import com.store.models.Product;
import com.store.models.Store;

import java.util.Map;

public class CustomerOperationsImpl implements CustomerOperations{

    @Override
    public Map<Product, Integer> addToCart(Customer customer, Store store, Product product, int quantityWanted, double wallet) {
         Map<Product, Integer> map = store.getProductMap();

             if (map.containsKey(product) && map.get(product) >= quantityWanted) {
                 if (customer.getCartMap().containsKey(product)) {
                     int i = customer.getCartMap().get(product) + quantityWanted;
                     if (i > map.get(product) ) {

                         System.out.println("Sorry, we don't have up to " + quantityWanted + " " + product.getProductName() +" left in stock");
                     } else {
                         customer.getCartMap().put(product,i);
                     }

                 }else {
                     customer.getCartMap().put(product,quantityWanted);
                 }

             } else if (map.containsKey(product) && map.get(product) < quantityWanted) {
                 System.out.println("Sorry, we only have " + map.get(product) + " in stock");
             } else {
                 System.out.println("We don't have "  + product.getProductName());
             }

         return customer.getCartMap();
    }
}
