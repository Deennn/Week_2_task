package com.store.internalOperations;

import com.store.enums.Role;
import com.store.exceptions.InsufficientFundException;
import com.store.exceptions.StaffNotAuthorizedException;
import com.store.models.Customer;
import com.store.models.Staff;
import com.store.models.Store;
import com.store.models.Product;

import java.util.Map;

import static com.store.enums.Role.CASHIER;
import static com.store.enums.Role.MANAGER;

public class InternalOperationsImpl implements InternalOperations{


    @Override
    public void addToStore(Staff admin, Store store, Product product, int quantityToBeAddedStore) throws StaffNotAuthorizedException {

        if (admin.getRole().equals(MANAGER)) {
                if (store.getProductMap().containsKey(product)) {
                  if (store.getProductMap().get(product) >= 1) {
                      int i = store.getProductMap().get(product) + quantityToBeAddedStore;
                      store.getProductMap().put(product,i);
                  }
                } else {
                    store.getProductMap().put(product,quantityToBeAddedStore);
                }

        } else {
            throw new StaffNotAuthorizedException("You're not authorized to perform this operation");
        }
    }

    @Override
    public void sellProduct(Staff staff, Store store, Customer customer) throws InsufficientFundException, StaffNotAuthorizedException {
        Map<Product,Integer> map = customer.getCartMap();
        double customerWallet =  customer.getWallet();
        double storeAccount = store.getStoreAccount();
        double totalAmount = 0.00;
        double totalAmountPerProduct = 0.00;
        if (!staff.getRole().equals(CASHIER)) {
            throw new StaffNotAuthorizedException(" You're not Authorized to perform this operation");
        } else {
            for (Map.Entry<Product,Integer> entry : map.entrySet()) {
                double productPrice = entry.getKey().getProductPrice();
                int newProductQuantity = 0;
                int  productQuantity = entry.getValue();

                totalAmountPerProduct = productPrice * productQuantity;


                System.out.println(totalAmountPerProduct);
                totalAmount += totalAmountPerProduct;


            }


        }
        if (totalAmount > customerWallet) {
            throw  new InsufficientFundException("Insufficient Funds");
        }
            else {
                storeAccount += totalAmount;
        }
        map.clear();

    }
}
