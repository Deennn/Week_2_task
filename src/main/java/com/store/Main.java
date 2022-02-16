package com.store;

import com.store.application.Application;
import com.store.application.ApplicationImpl;
import com.store.customerOperations.CustomerOperations;
import com.store.customerOperations.CustomerOperationsImpl;
import com.store.enums.Gender;
import com.store.enums.Qualification;
import com.store.enums.Role;
import com.store.exceptions.*;
import com.store.internalOperations.InternalOperations;
import com.store.internalOperations.InternalOperationsImpl;
import com.store.models.*;
import com.store.recruitment.Recruitment;
import com.store.recruitment.recruitmentImpl;

public class Main {

   public static void main(String[] args) throws StaffNotAuthorizedException, ApplicantsAlreadyAppliedException, OverStaffedException, InsufficientFundException, ProductOutOfStockException, ProductNotInStockException {
        Category FoodStuff = new Category("FoodStuff");
        Product product = new Product("Milk", "powder milk",FoodStuff,1000);
        Product product1 = new Product("Sugar","cube sugar",FoodStuff,10000);
        Product product2 = new Product("Garri","Ijebu garri", FoodStuff,2000);
        Applicant applicant = new Applicant("deee","sss","jdjd","dskdk",Gender.FEMALE,Qualification.BSC,Role.CASHIER);
        Customer customer = new Customer("Deenn","lawal","a@gmail.com","edo",Gender.MALE,2000000.0,3);
        Store store = new Store("drogo","tech park",0.00);
        Staff manager = new Staff(Role.MANAGER);
        Staff cashier = new Staff(Role.CASHIER);

        InternalOperations internalOperations = new InternalOperationsImpl();
        CustomerOperations customerOperations = new CustomerOperationsImpl();
        Application application = new ApplicationImpl();
        Recruitment recruitment = new recruitmentImpl();
        internalOperations.addProductToStore(manager,store,product,20);
        internalOperations.addProductToStore(manager,store,product1,11);
        internalOperations.addProductToStore(manager,store,product,5);
        internalOperations.addProductToStore(manager,store,product1,11);
        internalOperations.addProductToStore(manager,store,product2,12);
        System.out.println(store.getProductMap());
        customerOperations.buyProduct(customer,store,product2,12);
        customerOperations.buyProduct(customer,store,product1,1);
        customerOperations.buyProduct(customer,store,product1,21);
        customerOperations.buyProduct(customer,store,product,25);
        internalOperations.sellProducts(cashier,store,customer);
//        application.apply(applicant,store);
//        recruitment.hire(applicant,manager,store);





//        System.out.println(product);
        System.out.println(store.getProductMap());
        System.out.println(customer.getCartMap());

//
//        Applicant applicant = new Applicant("deenn","lawal","aaa","sdhd", Gender.FEMALE, Qualification.BSC, Role.CASHIER);
//        System.out.println(store.getProductMap());
//        System.out.println(applicant);

    }
}
