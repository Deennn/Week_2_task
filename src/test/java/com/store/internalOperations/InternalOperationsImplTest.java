package com.store.internalOperations;

import com.store.customerOperations.CustomerOperationsImpl;
import com.store.enums.Gender;
import com.store.enums.Role;
import com.store.exceptions.InsufficientFundException;
import com.store.exceptions.ProductNotInStockException;
import com.store.exceptions.ProductOutOfStockException;
import com.store.exceptions.StaffNotAuthorizedException;
import com.store.models.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class InternalOperationsImplTest {

    Store store;
    Category Food;
    Product product;
    Product product1;
    Staff manager ;
    Staff cashier;
    Customer customer;

    InternalOperations internalOperations;
    CustomerOperationsImpl customerOperations = new CustomerOperationsImpl();

    @BeforeEach
    void setUp() {
        store = new Store("DrogoStore","Tech_Park");
        Food = new Category("Food");

        manager = new Staff(Role.MANAGER);
        cashier = new Staff(Role.CASHIER);
        internalOperations = new InternalOperationsImpl();

        customer = new Customer("Deenn","lawal","a@gmail.com","edo", Gender.MALE);


    }

    @Test
    void addProductToStore() throws StaffNotAuthorizedException, IOException {
        internalOperations.addProductToStore(manager,store);
        Assertions.assertEquals(13,store.getProductList().length);
    }
    @Test
    void addProductToStores() throws StaffNotAuthorizedException, IOException {
        internalOperations.addProductToStore(manager,store);
        Assertions.assertEquals(13,store.getProductList().length);
    }
    @Test
    void addProductToStoress() throws StaffNotAuthorizedException, IOException {

        Assertions.assertThrows(StaffNotAuthorizedException.class, ()-> internalOperations.addProductToStore(cashier,store));
    }

    @Test
    void sellProducts() {
        Assertions.assertThrows(StaffNotAuthorizedException.class, ()-> internalOperations.sellProducts(manager,store,customer));
    }

    @Test
    void shouldThrowInsufficentFundException() throws StaffNotAuthorizedException, IOException, InsufficientFundException, ProductOutOfStockException, ProductNotInStockException {
        internalOperations.addProductToStore(manager,store);
        customerOperations.addProductToCart(customer,store,"Bread",4);
        customerOperations.loadCustomerAccount(customer,10.0);

        Assertions.assertThrows(InsufficientFundException.class, () -> internalOperations.sellProducts(cashier,store,customer));
    }
    @Test
    void shouldThrowIn() throws StaffNotAuthorizedException, IOException, InsufficientFundException, ProductOutOfStockException, ProductNotInStockException {
        internalOperations.addProductToStore(manager,store);
        customerOperations.addProductToCart(customer,store,"Bread",4);
        customerOperations.loadCustomerAccount(customer,100000000.0);
        internalOperations.sellProducts(cashier,store,customer);

        Assertions.assertEquals(0,customer.getCartMap().size());
    }
}