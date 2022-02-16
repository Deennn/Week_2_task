package com.store.customerOperations;

import com.store.enums.Gender;
import com.store.enums.Qualification;
import com.store.enums.Role;
import com.store.exceptions.ProductNotInStockException;
import com.store.exceptions.ProductOutOfStockException;
import com.store.exceptions.StaffNotAuthorizedException;
import com.store.internalOperations.InternalOperations;
import com.store.internalOperations.InternalOperationsImpl;
import com.store.models.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CustomerOperationsImplTest {

    Category FoodStuff = new Category("FoodStuff");
    Product product = new Product("Milk", "powder milk",FoodStuff,1000);
    Product product1 = new Product("Sugar","cube sugar",FoodStuff,10000);
    Product product2 = new Product("Garri","Ijebu garri", FoodStuff,2000);
    Applicant applicant = new Applicant("deee","sss","jdjd","dskdk", Gender.FEMALE, Qualification.BSC, Role.CASHIER);
    Customer customer = new Customer("Deenn","lawal","a@gmail.com","edo",Gender.MALE,1000,3);
    Store store = new Store("drogo","tech park",0.00);
    Staff manager = new Staff(Role.MANAGER);
    Staff cashier = new Staff(Role.CASHIER);

    InternalOperations internalOperations = new InternalOperationsImpl();
    CustomerOperationsImpl customerOperations = new CustomerOperationsImpl();

    @Test
    void shouldCheckProductExistInStore() throws StaffNotAuthorizedException {
        internalOperations.addProductToStore(manager,store,product,20);
        Assertions.assertThrows(ProductNotInStockException.class, ()-> customerOperations.buyProduct(customer,store,product1,25));
    }

    @Test
    void shouldCheckIfTheProductIsOutOfStock() throws StaffNotAuthorizedException {
        internalOperations.addProductToStore(manager,store,product,20);
        Assertions.assertThrows(ProductOutOfStockException.class, ()-> customerOperations.buyProduct(customer,store,product,21));
    }
    @Test
    void ShouldCheckTheQuantityOfProductAddToCart() throws StaffNotAuthorizedException, ProductOutOfStockException, ProductNotInStockException {
        internalOperations.addProductToStore(manager,store,product,20);
        internalOperations.addProductToStore(manager,store,product,5);
        customerOperations.buyProduct(customer,store,product,20);
        Assertions.assertEquals(20,customer.getCartMap().get(product));
    }

    @Test
    void ShouldCheckProductOutOfStockException() throws StaffNotAuthorizedException, ProductOutOfStockException, ProductNotInStockException {
        internalOperations.addProductToStore(manager,store,product,20);
        customerOperations.buyProduct(customer,store,product,15);
        Assertions.assertThrows(ProductOutOfStockException.class, ()->customerOperations.buyProduct(customer,store,product,21));

    }

    @Test
    void ShouldCheckTheQuantityOfProductWhenTwoProductsAreAdded() throws StaffNotAuthorizedException, ProductOutOfStockException, ProductNotInStockException {
        internalOperations.addProductToStore(manager,store,product,45);
        customerOperations.buyProduct(customer,store,product,20);
        customerOperations.buyProduct(customer,store,product,20);
        Assertions.assertEquals(40,customer.getCartMap().get(product));
    }

//    @Test
//    void buyProduct5() throws StaffNotAuthorizedException, ProductOutOfStockException, ProductNotInStockException {
//        internalOperations.addProductToStore(manager,store,product,20);
//        customerOperations.buyProduct(customer,store,product,15);
//        Assertions.assertThrows(ProductOutOfStockException.class, ()->customerOperations.buyProduct(customer,store,product,21));
//
//    }
}