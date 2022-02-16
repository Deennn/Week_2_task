package com.store.internalOperations;

import com.store.exceptions.InsufficientFundException;
import com.store.exceptions.StaffNotAuthorizedException;
import com.store.models.Customer;
import com.store.models.Staff;
import com.store.models.Store;
import com.store.models.Product;

public interface InternalOperations {
    void addProductToStore(Staff admin, Store store, Product product, int quantityToBeAddedStore) throws StaffNotAuthorizedException;
    void sellProducts(Staff staff, Store store, Customer customer) throws InsufficientFundException, StaffNotAuthorizedException;
    String printReceipt(Store store, Customer customer,double totalAmount);
    double getCustomerPrice();
}
