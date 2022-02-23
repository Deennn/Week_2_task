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

import java.io.IOException;
import java.util.Arrays;

public class Main {

   public static void main(String[] args) throws StaffNotAuthorizedException, ApplicantsAlreadyAppliedException, OverStaffedException, InsufficientFundException, ProductOutOfStockException, ProductNotInStockException, IOException {
        Category FoodStuff = new Category("FoodStuff");
//        Product milk = new Product("Milk", "powder milk",FoodStuff,1000,10);
//        Product sugar = new Product("Sugar","cube sugar",FoodStuff,10000,14);
//        Product garri = new Product("Garri","Ijebu garri", FoodStuff,2000,12);
        Applicant applicant = new Applicant("deee","sss","jdjd","dskdk",Gender.FEMALE,Qualification.BSC,Role.CASHIER);
        Customer sam= new Customer("Sam","Lawal","ade@gmail.com","Edo Park",Gender.MALE);
//        Customer sam = new Customer("Sam","lawal","a@gmail.com","edo",Gender.MALE,20000.0,3);
        Store store = new Store("drogo","tech park");
        Staff manager = new Staff(Role.MANAGER);
        Staff cashier = new Staff(Role.CASHIER);

        InternalOperations internalOperations = new InternalOperationsImpl();
        CustomerOperations customerOperations = new CustomerOperationsImpl();
        Application application = new ApplicationImpl();
        Recruitment recruitment = new recruitmentImpl();

        application.apply(applicant, store);
        recruitment.hire(applicant, manager, store);
        System.out.println(store.getApplicants().size());
        System.out.println(store.getStaffs().size());

        Staff deee = store.getStaffs().get(0);
        System.out.println(deee.getFirstName());

        internalOperations.addProductToStore(manager,store);
        System.out.println(Arrays.toString(store.getProductList()));
//        customerOperations.buyProduct(sam,store,"garr",5);
        customerOperations.loadCustomerAccount(sam,100000000);
        customerOperations.addProductToCart(sam,store,"Bread",4);
        customerOperations.addProductToCart(sam,store,"Garri",4);
        customerOperations.addProductToCart(sam,store,"Garri",4);
        customerOperations.addProductToCart(sam,store,"garri",10);
        customerOperations.addProductToCart(sam,store,"milk",12);
        System.out.println("sam's cart --> " +sam.getCartMap());
        internalOperations.sellProducts(cashier,store,sam);
        System.out.println();
//        System.out.println(Arrays.toString(store.getProductList()));
        System.out.println("sam's cart --> " +sam.getCartMap());
//        System.out.println(store.getProductMap());

//        customerOperations.buyProduct(sam,store,milk,12);
//        customerOperations.buyProduct(sam,store,sugar,10);
//        System.out.println(sam.getCartMap());

//        internalOperations.sellProducts(deee,store,sam);
//        System.out.println(store.getProductMap());

//        System.out.println(sam.getCartMap());




//        internalOperations.addProductToStore(manager,store,sugar,11);
//        internalOperations.addProductToStore(manager,store,milk,5);
//        internalOperations.addProductToStore(manager,store,sugar,11);
//        internalOperations.addProductToStore(manager,store,garri,12);
//        System.out.println(store.getProductMap());
//        customerOperations.buyProduct(sam,store,sugar,1);
//        customerOperations.buyProduct(sam,store,sugar,21);
//        customerOperations.buyProduct(sam,store,milk,25);
//        application.apply(applicant,store);
//        recruitment.hire(applicant,manager,store);





//        System.out.println(milk);
//        System.out.println(store.getProductMap());
//        System.out.println(sam.getCartMap());

//
//        Applicant applicant = new Applicant("deenn","lawal","aaa","sdhd", Gender.FEMALE, Qualification.BSC, Role.CASHIER);
//        System.out.println(store.getProductMap());
//        System.out.println(applicant);

//        if (true) {
//             System.out.println("true");
//        }
//        if (false) {
//             System.out.println("false");
//        }

    }
}
