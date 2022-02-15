package com.store.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Store {

    private String name;
    private String address;
    private double storeAccount;
    private List<Staff> staffs;
    private List<Applicant> applicants;
    private Map<Product,Integer> productMap;

    public Store(String name, String address,double storeAccount) {
        this.name = name;
        this.address = address;
        this.storeAccount = 0.00;
        this.staffs = new ArrayList<>();
        this.applicants = new ArrayList<>();
        this.productMap = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getStoreAccount() {
        return storeAccount;
    }

    public void setStoreAccount(double storeAccount) {
        this.storeAccount = storeAccount;
    }

    public List<Staff> getStaffs() {
        return staffs;
    }


    public List<Applicant> getApplicants() {
        return applicants;
    }


    public Map<Product, Integer> getProductMap() {
        return productMap;
    }


    @Override
    public String toString() {
        return "Store{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", storeAccount=" + storeAccount +
                ", staffs=" + staffs +
                ", applicants=" + applicants +
                ", productList=" + productMap +
                '}';
    }
}
