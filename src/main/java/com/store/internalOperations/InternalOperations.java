package com.store.internalOperations;

import com.store.exceptions.InsufficientFundException;
import com.store.exceptions.StaffNotAuthorizedException;
import com.store.models.Customer;
import com.store.models.Staff;
import com.store.models.Store;
import com.store.models.Product;

import java.io.IOException;

public interface InternalOperations {
    void addProductToStore(Staff admin, Store store) throws StaffNotAuthorizedException, IOException;
    void sellProducts(Staff staff, Store store, Customer customer) throws InsufficientFundException, StaffNotAuthorizedException;
    String printReceipt(Store store, Customer customer,double totalAmount);

}
