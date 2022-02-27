package com.store.internalOperations;

import com.store.customerOperations.CustomerOperationsImpl;
import com.store.enums.Gender;
import com.store.enums.Role;
import com.store.exceptions.InsufficientFundException;
import com.store.exceptions.ProductNotInStockException;
import com.store.exceptions.ProductOutOfStockException;
import com.store.exceptions.StaffNotAuthorizedException;
import com.store.models.*;
import com.store.models.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class InternalOperationsImplTest {

    Store store;
    Category Food;
    Product product;
    Product product1;
    Staff ade;
    Staff chisom;
    Customer deenn;

    InternalOperations internalOperations;
    CustomerOperationsImpl customerOperations = new CustomerOperationsImpl();

    @BeforeEach
    void setUp() {
        store = new Store("DrogoStore","Tech_Park",chisom);
        Food = new Category("Food");

        ade = new Staff(Role.MANAGER);
        chisom = new Staff(Role.CASHIER);
        internalOperations = new InternalOperationsImpl();

        deenn = new Customer("Deenn","lawal","a@gmail.com","edo", Gender.MALE);


    }

    @Test
    void shouldCheckNumberOfProductsAddedToStore() throws StaffNotAuthorizedException, IOException {
        internalOperations.addProductToStore(ade,store);
        Assertions.assertEquals(13,store.getProductList().length);
    }

    @Test
    void shouldCheckIfTheProductsInStoreAreWhatWasAdded() throws StaffNotAuthorizedException, IOException {
        internalOperations.addProductToStore(ade,store);
        Assertions.assertTrue(store.getProductList()[7].getProductName().equalsIgnoreCase("juice"));
        Assertions.assertEquals(10,store.getProductList()[0].getProductQuantity());
    }
    @Test
    void shouldCheckWhoseAddingProductToStore() throws StaffNotAuthorizedException, IOException {

        Assertions.assertThrows(StaffNotAuthorizedException.class, ()-> internalOperations.addProductToStore(chisom,store));
    }

    @Test
    void sellProducts() {
        Assertions.assertThrows(StaffNotAuthorizedException.class, ()-> internalOperations.sellProducts(ade,store, deenn));
    }

    @Test
    void shouldThrowInsufficientFundException() throws StaffNotAuthorizedException, IOException, InsufficientFundException, ProductOutOfStockException, ProductNotInStockException {
        internalOperations.addProductToStore(ade,store);
        customerOperations.addProductToCart(deenn,store,"Bread",4);
        customerOperations.loadCustomerAccount(deenn,10.0);
        Assertions.assertEquals(10.00, deenn.getAccount().getAccountBalance());
        Assertions.assertThrows(InsufficientFundException.class, () -> internalOperations.sellProducts(chisom,store, deenn));
    }
    @Test
    void shouldCheckIfCustomerCartIsEmptyAfterBuying() throws StaffNotAuthorizedException, IOException, InsufficientFundException, ProductOutOfStockException, ProductNotInStockException {
        internalOperations.addProductToStore(ade,store);
        customerOperations.addProductToCart(deenn,store,"Bread",4);
        customerOperations.loadCustomerAccount(deenn,100000000.0);
        internalOperations.sellProducts(chisom,store, deenn);

        Assertions.assertEquals(0, deenn.getCartMap().size());
    }
    @Test
    void shouldCheckIfCustomerWalletAfterBuying() throws StaffNotAuthorizedException, IOException, InsufficientFundException, ProductOutOfStockException, ProductNotInStockException {
        internalOperations.addProductToStore(ade,store);
        customerOperations.addProductToCart(deenn,store,"Bread",4);
        customerOperations.loadCustomerAccount(deenn,100000000.0);
        double balanceBeforeBuying = deenn.getAccount().getAccountBalance();
        internalOperations.sellProducts(chisom,store, deenn);

        Assertions.assertTrue(balanceBeforeBuying > deenn.getAccount().getAccountBalance());
    }
    @Test
    void shouldCheckIfStore() throws StaffNotAuthorizedException, IOException, InsufficientFundException, ProductOutOfStockException, ProductNotInStockException {
        internalOperations.addProductToStore(ade,store);
        customerOperations.addProductToCart(deenn,store,"Bread",4);
        customerOperations.loadCustomerAccount(deenn,100000000.0);
        double balanceBeforeBuying = deenn.getAccount().getAccountBalance();
        internalOperations.sellProducts(chisom,store, deenn);

        Assertions.assertTrue(balanceBeforeBuying > deenn.getAccount().getAccountBalance());
    }
}