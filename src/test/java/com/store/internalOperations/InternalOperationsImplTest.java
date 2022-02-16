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

    InternalOperations internalOperations = new InternalOperationsImpl();
    CustomerOperationsImpl customerOperations = new CustomerOperationsImpl();

    @BeforeEach
    void setUp() {
        store = new Store("DrogoStore","Tech_Park",0.00);
        Food = new Category("Food");
        product = new Product("Garri","Ijebu",Food,100.0);
        product1 = new Product("Milk","Powder milk",Food,100.0);
        manager = new Staff(Role.MANAGER);
        cashier = new Staff(Role.CASHIER);

        customer = new Customer("Deenn","lawal","a@gmail.com","edo", Gender.MALE,2000000.0,3);


    }

    @Test
    void ShouldCheckStaffNotAuthorizedException() {
        Assertions.assertThrows(StaffNotAuthorizedException.class, () -> internalOperations.addProductToStore(cashier,store,product,1));
    }
    @Test
    void ShouldCheckWhenTwoProductAreAddedToStore() throws StaffNotAuthorizedException {
        internalOperations.addProductToStore(manager,store,product,20);
        internalOperations.addProductToStore(manager,store,product,20);
        assertTrue(store.getProductMap().containsKey(product));
        assertEquals(40, store.getProductMap().get(product));

    }
    @Test
    void ShouldCheckWhenOneProductAreAddedToStore() throws StaffNotAuthorizedException {
        internalOperations.addProductToStore(manager,store,product,12);

        assertTrue(store.getProductMap().containsKey(product));
        assertEquals(12, store.getProductMap().get(product));

    }
    @Test
    void ShouldCheckTheSizeOfTheProductMap() throws StaffNotAuthorizedException {
        internalOperations.addProductToStore(manager,store,product,20);
        internalOperations.addProductToStore(manager,store,product1,20);
        assertTrue(store.getProductMap().containsKey(product));
        assertEquals(2, store.getProductMap().size());

    }


    @Test
    void shouldCheckIfSellerIsNotCashier() throws StaffNotAuthorizedException {
        internalOperations.addProductToStore(manager,store,product,12);
        Assertions.assertThrows(StaffNotAuthorizedException.class, ()-> internalOperations.sellProducts(manager,store,customer));
    }

    @Test
    void shouldCheckIfTheTotalAmountIsEqualToProductPrice() throws StaffNotAuthorizedException, InsufficientFundException, ProductOutOfStockException, ProductNotInStockException {
        internalOperations.addProductToStore(manager, store, product, 12);
        customerOperations.buyProduct(customer,store,product,12,2000.00);
        internalOperations.sellProducts(cashier, store, customer);
        double total = 5;
        for (Map.Entry<Product, Integer> entry : store.getProductMap().entrySet()) {
            total += entry.getKey().getProductPrice();
        }

        Assertions.assertEquals(1200.0,total, 0.00);
    }

    @Test
    void printReceipt() {
    }
}