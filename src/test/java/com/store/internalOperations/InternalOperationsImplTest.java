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
    void addProductToStore() {
    }

    @Test
    void sellProducts() {
    }

    @Test
    void printReceipt() {
    }
}