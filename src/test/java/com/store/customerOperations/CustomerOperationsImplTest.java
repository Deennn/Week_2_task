package com.store.customerOperations;

import com.store.enums.Gender;
import com.store.enums.Qualification;
import com.store.enums.Role;
import com.store.exceptions.ProductNotInStockException;
import com.store.exceptions.ProductOutOfStockException;
import com.store.exceptions.StaffNotAuthorizedException;
import com.store.internalOperations.InternalOperations;
import com.store.internalOperations.InternalOperationsImpl;
import com.store.models.Applicant;
import com.store.models.Customer;
import com.store.models.Staff;
import com.store.models.Store;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class CustomerOperationsImplTest {

//    Category FoodStuff = new Category("FoodStuff");
//    Product product = new Product("Milk", "powder milk",FoodStuff,1000);
//    Product product1 = new Product("Sugar","cube sugar",FoodStuff,10000);
//    Product product2 = new Product("Garri","Ijebu garri", FoodStuff,2000);
    Applicant applicant = new Applicant("deee","sss","jdjd","dskdk", Gender.FEMALE, Qualification.BSC, Role.CASHIER);
    Customer customer = new Customer("Deenn","lawal","a@gmail.com","edo",Gender.MALE);
    Store store = new Store("drogo","tech park");
    Staff manager = new Staff(Role.MANAGER);
    Staff cashier = new Staff(Role.CASHIER);

    InternalOperations internalOperations = new InternalOperationsImpl();
    CustomerOperationsImpl customerOperations = new CustomerOperationsImpl();
    @Test
    void shouldCheckTheQuantityOfProductInStore() throws StaffNotAuthorizedException, IOException {
        internalOperations.addProductToStore(manager,store);
        Assert.assertThrows(ProductNotInStockException.class, ()-> customerOperations.addProductToCart(customer,store,"Garri",15));
    }

    @Test
    void shouldCheckTheSizeOfTheCustomerCart() throws StaffNotAuthorizedException, IOException, ProductOutOfStockException, ProductNotInStockException {
        internalOperations.addProductToStore(manager,store);
        customerOperations.addProductToCart(customer,store,"Garri",9);
        Assertions.assertEquals(1,customer.getCartMap().size());
    }

    @Test
    void loadCustomerAccount() {
        customerOperations.loadCustomerAccount(customer,100.0);
        Assertions.assertEquals(100,customer.getAccount().getAccountBalance(),0.00);
    }
}