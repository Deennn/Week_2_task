package com.store.models;

import java.util.*;


public class Store {

    private String name;
    private String address;
    private Account storeAccount;
//    private double storeAccount;
    private List<Staff> staffs;
    private List<Applicant> applicants;
    private Product[] productList = new Product[1];

    public Store(String name, String address) {
        this.name = name;
        this.address = address;
//        this.storeAccount = new ;
        this.storeAccount = new Account(this.name);
        this.staffs = new ArrayList<>();
        this.applicants = new ArrayList<>();
//        this.productList = new Product[0];
    }

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public String getAddress() {
        return address;
    }

//    public void setAddress(String address) {
//        this.address = address;
//    }

    public Account getStoreAccount() {
        return storeAccount;
    }

//    public double getStoreAccount() {
//        return storeAccount;
//    }


//    public void setStoreAccount(double storeAccount) {
//        this.storeAccount = storeAccount;
//    }

    public List<Staff> getStaffs() {
        return staffs;
    }


    public List<Applicant> getApplicants() {
        return applicants;
    }


    public Product[] getProductList() {
        return productList;
    }

    public void setProductList(Product[] productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "Store{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", storeAccount=" + storeAccount +
                ", staffs=" + staffs +
                ", applicants=" + applicants +
                ", productList=" + Arrays.toString(productList) +
                '}';
    }
}
