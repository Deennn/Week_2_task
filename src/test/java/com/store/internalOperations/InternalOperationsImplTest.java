package com.store.internalOperations;

import com.store.enums.Role;
import com.store.exceptions.StaffNotAuthorizedException;
import com.store.models.Category;
import com.store.models.Product;
import com.store.models.Staff;
import com.store.models.Store;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InternalOperationsImplTest {

    Store store;
    Category Food;
    Product product;
    Product product1;
    Staff manager ;
    Staff cashier;

    InternalOperations internalOperations = new InternalOperationsImpl();

    @BeforeEach
    void setUp() {
        store = new Store("DrogoStore","Tech_Park",0.00);
        Food = new Category("Food");
        product = new Product("Garri","Ijebu",Food,100.0);
        product1 = new Product("Milk","Powder milk",Food,100.0);
        manager = new Staff(Role.MANAGER);
        cashier = new Staff(Role.CASHIER);

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
    void sellProducts() {
    }

    @Test
    void printReceipt() {
    }
}